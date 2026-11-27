package com.hehe.planduh.ui.format

import java.time.DayOfWeek
import java.time.Month

private val DAY_NAMES = listOf("Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu", "Minggu")
private val MONTH_NAMES = listOf(
    "Januari", "Februari", "Maret", "April", "Mei", "Juni",
    "Juli", "Agustus", "September", "Oktober", "November", "Desember",
)

/** Full day name shown in the UI: "Kamis". */
fun DayOfWeek.displayName(): String = DAY_NAMES[value - 1]

/** Three-letter day name: "Kam". */
fun DayOfWeek.shortName(): String = displayName().take(3)

/** Full month name shown in the UI: "November". */
fun Month.displayName(): String = MONTH_NAMES[value - 1]

/** Three-letter month name: "Nov". */
fun Month.shortName(): String = displayName().take(3)
