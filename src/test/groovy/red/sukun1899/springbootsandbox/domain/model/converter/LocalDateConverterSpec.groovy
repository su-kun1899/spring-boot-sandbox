package red.sukun1899.springbootsandbox.domain.model.converter

import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Date
import java.time.LocalDate

/**
 * @author su-kun1899
 */
class LocalDateConverterSpec extends Specification {
    LocalDateConverter sut

    def setup() {
        sut = new LocalDateConverter()
    }

    def "java.sql.Dateをjava.time.LocalDateに変換する"() {
        given:
        def date = new Date(2018, 5, 24)

        when:
        def actual = sut.convertToEntityAttribute(date)

        then:
        actual == date.toLocalDate()
    }

    def "java.time.LocalDateをjava.sql.Dateに変換する"() {
        given:
        def localDate = LocalDate.of(2017, 12, 3)

        when:
        def actual = sut.convertToDatabaseColumn(localDate)

        then:
        actual == Date.valueOf(localDate)
    }

    @Unroll
    def "#method は引数がnullの場合nullを返す"() {
        expect:
        sut."$method"(null) == null

        where:
        method                     | _
        "convertToEntityAttribute" | _
        "convertToDatabaseColumn"  | _
    }
}
