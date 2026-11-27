package com.hehe.planduh.data.dummy

import com.hehe.planduh.domain.model.Period
import com.hehe.planduh.domain.model.Schedule
import com.hehe.planduh.domain.model.Subject
import com.hehe.planduh.domain.model.Task
import com.hehe.planduh.domain.model.TaskStatus
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

/** Temporary data for the Home design. Will be replaced by a real data source (Room) later. */
object DummyData {
    /** Thursday, 19 November 2026 09:05. */
    val now: LocalDateTime = LocalDateTime.of(2026, 11, 19, 9, 5)

    // There is no User model in the ERD yet, so the user name lives here for now.
    const val USER_NAME = "Rina"

    val periods = listOf(
        Period(
            id = 1,
            userId = 1,
            name = "Semester Ganjil 2026/2027",
            academicYear = "2026/2027",
            semester = "Ganjil",
            isActive = true,
        ),
    )

    val subjects = listOf(
        Subject(id = 1, periodId = 1, name = "Matematika"),
        Subject(id = 2, periodId = 1, name = "IPA"),
        Subject(id = 3, periodId = 1, name = "Bahasa Inggris"),
    )

    val schedules = listOf(
        Schedule(
            id = 1, subjectId = 3, dayOfWeek = DayOfWeek.THURSDAY,
            startTime = LocalTime.of(7, 0), endTime = LocalTime.of(8, 30), room = "Ruang 08",
        ),
        Schedule(
            id = 2, subjectId = 1, dayOfWeek = DayOfWeek.THURSDAY,
            startTime = LocalTime.of(9, 30), endTime = LocalTime.of(11, 0), room = "Ruang 12",
        ),
        Schedule(
            id = 3, subjectId = 2, dayOfWeek = DayOfWeek.THURSDAY,
            startTime = LocalTime.of(11, 0), endTime = LocalTime.of(12, 30), room = "Lab. Sains",
        ),
    )

    val tasks = listOf(
        Task(
            id = 1,
            subjectId = 1,
            title = "Latihan Soal Bab 4 – MTK",
            deadline = LocalDateTime.of(2026, 11, 20, 19, 0),
            status = TaskStatus.NOT_DONE,
        ),
        Task(
            id = 2,
            subjectId = 1,
            title = "Latihan Soal Bab 4 – MTK",
            deadline = LocalDateTime.of(2026, 11, 20, 19, 0),
            status = TaskStatus.NOT_DONE,
        ),
        Task(
            id = 3,
            subjectId = 1,
            title = "Latihan Soal Bab 4 – MTK",
            deadline = LocalDateTime.of(2026, 11, 20, 19, 0),
            status = TaskStatus.NOT_DONE,
        ),
        Task(
            id = 4,
            subjectId = 1,
            title = "Latihan Soal Bab 4 – MTK",
            deadline = LocalDateTime.of(2026, 11, 20, 19, 0),
            status = TaskStatus.NOT_DONE,
        ),
        Task(
            id = 5,
            subjectId = 1,
            title = "Latihan Soal Bab 4 – MTK",
            deadline = LocalDateTime.of(2026, 11, 20, 19, 0),
            status = TaskStatus.NOT_DONE,
        ),
    )
}
