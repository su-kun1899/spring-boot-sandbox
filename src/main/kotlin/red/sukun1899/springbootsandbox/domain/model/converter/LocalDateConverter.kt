package red.sukun1899.springbootsandbox.domain.model.converter

import java.sql.Date
import java.time.LocalDate
import javax.persistence.AttributeConverter
import javax.persistence.Converter

/**
 * @author su-kun1899
 */
@Converter(autoApply = true)
class LocalDateConverter : AttributeConverter<LocalDate, Date> {
    override fun convertToDatabaseColumn(date: LocalDate?): Date? = date?.let { Date.valueOf(date) }
    override fun convertToEntityAttribute(value: Date?): LocalDate? = value?.toLocalDate()
}
