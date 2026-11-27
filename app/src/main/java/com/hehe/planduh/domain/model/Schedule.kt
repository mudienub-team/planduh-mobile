package com.hehe.planduh.domain.model

import java.time.DayOfWeek
import java.time.LocalTime

data class Schedule(
    val id: Int,
    val subjectId: Int,
    /** ERD: day_of_week 1-7. DayOfWeek using same ISO steps (1 = Monday ... 7 = Sunday). */
    val dayOfWeek: DayOfWeek,
    val startTime: LocalTime,
    val endTime: LocalTime? = null,
    val room: String? = null,
    val teacherName: String? = null,
)
