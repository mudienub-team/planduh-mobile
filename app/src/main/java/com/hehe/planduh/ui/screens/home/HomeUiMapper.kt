package com.hehe.planduh.ui.screens.home

import com.hehe.planduh.domain.model.Period
import com.hehe.planduh.domain.model.Schedule
import com.hehe.planduh.domain.model.Subject
import com.hehe.planduh.domain.model.Task
import com.hehe.planduh.domain.model.TaskStatus
import com.hehe.planduh.ui.components.molecules.ScheduleStatus
import com.hehe.planduh.ui.format.countdownText
import com.hehe.planduh.ui.format.deadlineText
import com.hehe.planduh.ui.format.shortName
import com.hehe.planduh.ui.format.timeRangeText
import com.hehe.planduh.ui.format.toClockText
import com.hehe.planduh.ui.format.toFullDateText
import com.hehe.planduh.ui.theme.SubjectPalette
import com.hehe.planduh.util.weekDates
import java.time.Duration
import java.time.LocalDateTime

/** Maps domain models to the Home state. [now] is passed in from outside to keep it testable. */
fun buildHomeUiState(
    now: LocalDateTime,
    userName: String,
    periods: List<Period>,
    subjects: List<Subject>,
    schedules: List<Schedule>,
    tasks: List<Task>,
): HomeUiState {
    val today = now.toLocalDate()
    val nowTime = now.toLocalTime()

    val activePeriodIds = periods.filter { it.isActive }.map { it.id }.toSet()
    val subjectById = subjects.filter { it.periodId in activePeriodIds }.associateBy { it.id }

    // Today's schedules, sorted by start time
    val todays = schedules
        .filter { it.subjectId in subjectById && it.dayOfWeek == today.dayOfWeek }
        .sortedBy { it.startTime }

    // "Next" = the first schedule that has not started yet
    val next = todays.firstOrNull { it.startTime.isAfter(nowTime) }

    val scheduleItems = todays.map { s ->
        val status = when {
            s.id == next?.id -> ScheduleStatus.Next
            !(s.endTime ?: s.startTime).isAfter(nowTime) -> ScheduleStatus.Done
            else -> ScheduleStatus.Upcoming
        }
        ScheduleUi(
            id = s.id,
            subjectName = subjectById.getValue(s.subjectId).name,
            startTime = s.startTime.toClockText(),
            endTime = s.endTime?.toClockText(),
            room = s.room,
            color = SubjectPalette.forId(s.subjectId),
            status = status,
        )
    }

    val nextClass = next?.let {
        NextClassUi(
            subjectName = subjectById.getValue(it.subjectId).name,
            timeRangeText = listOfNotNull(timeRangeText(it.startTime, it.endTime), it.room).joinToString(" · "),
            countdownText = countdownText(Duration.between(nowTime, it.startTime).toMinutes()),
        )
    }

    // Monday through Sunday of the current week
    val weekDays = today.weekDates().map { date ->
        WeekDayUi(
            label = date.dayOfWeek.shortName(),
            dateNumber = date.dayOfMonth,
            isSelected = date == today,
        )
    }

    val taskItems = tasks
        .filter { it.subjectId in subjectById && it.status == TaskStatus.NOT_DONE }
        .filter { it.deadline != null && it.deadline.isAfter(now) }
        .sortedBy { it.deadline }
        .take(3)
        .map { TaskUi(id = it.id, title = it.title, deadlineText = deadlineText(now, it.deadline!!)) }

    return HomeUiState(
        userName = userName,
        dateText = today.toFullDateText(),
        hasUnreadNotification = true, // temporary, there is no notification model yet
        nextClass = nextClass,
        weekDays = weekDays,
        schedules = scheduleItems,
        tasks = taskItems,
    )
}
