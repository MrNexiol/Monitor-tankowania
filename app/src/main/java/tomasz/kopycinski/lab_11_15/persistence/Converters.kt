package tomasz.kopycinski.lab_11_15.persistence

import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromTimestampToLocalDate(value: Long?): LocalDate? {
        return value?.let { LocalDate.ofEpochDay(it) }
    }

    @TypeConverter
    fun localDateToTimestamp(localDate: LocalDate?): Long? {
        return localDate?.toEpochDay()
    }
}