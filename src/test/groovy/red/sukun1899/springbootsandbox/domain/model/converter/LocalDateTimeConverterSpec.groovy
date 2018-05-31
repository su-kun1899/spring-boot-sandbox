package red.sukun1899.springbootsandbox.domain.model.converter

import spock.lang.Specification
import spock.lang.Unroll

import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.Month

/**
 * @author su-kun1899
 */
class LocalDateTimeConverterSpec extends Specification {
    LocalDateTimeConverter sut

    def setup() {
        sut = new LocalDateTimeConverter()
    }

    def "java.sql.Timestampをjava.time.LocalDateTimeに変換する"() {
        given:
        def timestamp = new Timestamp(2018, 6, 1, 1, 22, 15, 3)

        when:
        def actual = sut.convertToEntityAttribute(timestamp)

        then:
        actual == timestamp.toLocalDateTime()
    }

    def "java.time.LocalDateTimeをjava.sql.Timestampに変換する"() {
        given:
        def localDateTime = LocalDateTime.of(2018, Month.JUNE, 1, 1, 24)

        when:
        def actual = sut.convertToDatabaseColumn(localDateTime)

        then:
        actual == Timestamp.valueOf(localDateTime)
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
