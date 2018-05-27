package red.sukun1899.springbootsandbox.domain.model.converter

import java.sql.Time
import java.time.LocalTime
import javax.persistence.AttributeConverter

/**
 * @author su-kun1899
 */
class LocalTimeConverter : AttributeConverter<LocalTime, Time> {
    override fun convertToDatabaseColumn(time: LocalTime?): Time? = time?.let { Time.valueOf(time) }

    override fun convertToEntityAttribute(value: Time?): LocalTime? = value?.toLocalTime()

}