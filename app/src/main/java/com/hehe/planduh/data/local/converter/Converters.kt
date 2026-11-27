package com.hehe.planduh.data.local.converter

import androidx.room.TypeConverter
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

/**
 * java.time types are stored as ISO-8601 text (sortable lexicographically),
 * DayOfWeek as ISO int (1 = Monday ... 7 = Sunday).
 */
class Converters {
    @TypeConverter fun fromLocalDate(value: LocalDate?): String? = value?.toString()
    @TypeConverter fun toLocalDate(value: String?): LocalDate? = value?.let(LocalDate::parse)

    @TypeConverter fun fromLocalTime(value: LocalTime?): String? = value?.toString()
    @TypeConverter fun toLocalTime(value: String?): LocalTime? = value?.let(LocalTime::parse)

    @TypeConverter fun fromLocalDateTime(value: LocalDateTime?): String? = value?.toString()
    @TypeConverter fun toLocalDateTime(value: String?): LocalDateTime? = value?.let(LocalDateTime::parse)

    @TypeConverter fun fromDayOfWeek(value: DayOfWeek): Int = value.value
    @TypeConverter fun toDayOfWeek(value: Int): DayOfWeek = DayOfWeek.of(value)
}
