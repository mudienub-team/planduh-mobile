package com.hehe.planduh.domain.model

import java.time.LocalDate
import java.time.LocalDateTime

enum class TaskStatus { NOT_DONE, DONE }

data class Task(
    val id: Int,
    val subjectId: Int,
    val title: String,
    val description: String? = null,
    val givenDate: LocalDate? = null,
    val deadline: LocalDateTime? = null,
    val status: TaskStatus,
)
