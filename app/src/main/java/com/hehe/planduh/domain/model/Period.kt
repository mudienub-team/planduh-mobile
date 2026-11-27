package com.hehe.planduh.domain.model

data class Period(
    val id: Int,
    val userId: Int,
    val name: String,
    val academicYear: String,
    val semester: String,
    val isActive: Boolean,
)
