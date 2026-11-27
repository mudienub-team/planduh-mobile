package com.hehe.planduh.domain.model

import java.time.LocalDate

data class Note(
    val id: Int,
    val userId: Int,
    /** null = general note (not tied to a subject). */
    val subjectId: Int? = null,
    val title: String,
    val content: String? = null,
    val noteDate: LocalDate,
)
