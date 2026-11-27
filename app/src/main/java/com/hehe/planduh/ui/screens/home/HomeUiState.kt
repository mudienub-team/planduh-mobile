package com.hehe.planduh.ui.screens.home

import com.hehe.planduh.ui.components.molecules.ScheduleStatus
import com.hehe.planduh.ui.theme.SubjectColor

/** Display-ready state for the Home screen (text is already formatted by the mapper). */
data class HomeUiState(
    val userName: String,
    val dateText: String,
    val hasUnreadNotification: Boolean,
    val nextClass: NextClassUi?,
    val weekDays: List<WeekDayUi>,
    val schedules: List<ScheduleUi>,
    val tasks: List<TaskUi>,
)

data class NextClassUi(
    val subjectName: String,
    val timeRangeText: String,
    val countdownText: String,
)

data class WeekDayUi(
    val label: String,
    val dateNumber: Int,
    val isSelected: Boolean,
)

data class ScheduleUi(
    val id: Int,
    val subjectName: String,
    val startTime: String,
    val endTime: String?,
    val room: String?,
    val color: SubjectColor,
    val status: ScheduleStatus,
)

data class TaskUi(
    val id: Int,
    val title: String,
    val deadlineText: String,
)
