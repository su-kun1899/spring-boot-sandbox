package red.sukun1899.springbootsandbox.domain.model.converter

import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Time
import java.time.LocalTime

/**
 * @author su-kun1899
 */
class LocalTimeConverterSpec extends Specification {
    LocalTimeConverter sut

    def setup() {
        sut = new LocalTimeConverter()
    }

    def "java.sql.Timeをjava.time.LocalTimeに変換する"() {
        given:
        def time = new Time(8, 39, 15)

        when:
        def actual = sut.convertToEntityAttribute(time)

        then:
        actual == time.toLocalTime()
    }

    def "java.time.LocalTimeをjava.sql.Timeに変換する"() {
        given:
        def localTime = LocalTime.of(13, 5, 3)

        when:
        def actual = sut.convertToDatabaseColumn(localTime)

        then:
        actual == Time.valueOf(localTime)
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
