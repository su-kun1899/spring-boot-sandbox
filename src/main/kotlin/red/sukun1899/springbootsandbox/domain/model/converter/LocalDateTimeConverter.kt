package red.sukun1899.springbootsandbox.domain.model.converter

import java.sql.Timestamp
import java.time.LocalDateTime
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * @author su-kun1899
 */
@Converter(autoApply = true)
class LocalDateTimeConverter : AttributeConverter<LocalDateTime, Timestamp> {
    override fun convertToDatabaseColumn(dateTime: LocalDateTime?): Timestamp? =
            dateTime?.let { Timestamp.valueOf(dateTime) }

    override fun convertToEntityAttribute(value: Timestamp?): LocalDateTime? = value?.toLocalDateTime()
}