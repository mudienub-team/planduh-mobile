package com.hehe.planduh.ui.format

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.Locale

/** "07:05". */
fun LocalTime.toClockText(): String = String.format(Locale.ROOT, "%02d:%02d", hour, minute)

/** "07:00 – 08:30", or just "07:00" when there is no end time. */
fun timeRangeText(start: LocalTime, end: LocalTime?): String =
    if (end != null) "${start.toClockText()} – ${end.toClockText()}" else start.toClockText()

/** "Kamis, 19 November 2026". */
fun LocalDate.toFullDateText(): String =
    "${dayOfWeek.displayName()}, $dayOfMonth ${month.displayName()} $year"

/** "19 Nov". */
fun LocalDate.toShortDateText(): String = "$dayOfMonth ${month.shortName()}"

/** "25 menit lagi", "2 jam lagi", "1 jam 30 menit lagi". */
fun countdownText(minutes: Long): String {
    val h = minutes / 60
    val m = minutes % 60
    return when {
        h == 0L -> "$m menit lagi"
        m == 0L -> "$h jam lagi"
        else -> "$h jam $m menit lagi"
    }
}

/** "Deadline hari ini, 19 Nov · 19:00" / "besok, ..." / "20 Nov · 19:00". */
fun deadlineText(now: LocalDateTime, deadline: LocalDateTime): String {
    val date = deadline.toLocalDate().toShortDateText()
    val label = when (ChronoUnit.DAYS.between(now.toLocalDate(), deadline.toLocalDate())) {
        0L -> "hari ini, $date"
        1L -> "besok, $date"
        else -> date
    }
    return "Deadline $label · ${deadline.toLocalTime().toClockText()}"
}
