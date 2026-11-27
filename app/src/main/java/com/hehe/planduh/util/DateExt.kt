package com.hehe.planduh.util

import java.time.DayOfWeek
import java.time.LocalDate

/** The Monday of the week this date falls in. */
fun LocalDate.startOfWeek(): LocalDate =
    minusDays((dayOfWeek.value - DayOfWeek.MONDAY.value).toLong())

/** Monday through Sunday of the week this date falls in. */
fun LocalDate.weekDates(): List<LocalDate> = startOfWeek().let { monday -> (0L..6L).map(monday::plusDays) }
