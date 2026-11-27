package com.hehe.planduh.data.local.mapper

import com.hehe.planduh.data.local.entity.NoteEntity
import com.hehe.planduh.data.local.entity.PeriodEntity
import com.hehe.planduh.data.local.entity.ScheduleEntity
import com.hehe.planduh.data.local.entity.SubjectEntity
import com.hehe.planduh.data.local.entity.TaskEntity
import com.hehe.planduh.domain.model.Note
import com.hehe.planduh.domain.model.Period
import com.hehe.planduh.domain.model.Schedule
import com.hehe.planduh.domain.model.Subject
import com.hehe.planduh.domain.model.Task

fun PeriodEntity.toDomain() = Period(id, userId, name, academicYear, semester, isActive)
fun Period.toEntity() = PeriodEntity(id, userId, name, academicYear, semester, isActive)

fun SubjectEntity.toDomain() = Subject(id, periodId, name)
fun Subject.toEntity() = SubjectEntity(id, periodId, name)

fun ScheduleEntity.toDomain() = Schedule(id, subjectId, dayOfWeek, startTime, endTime, room, teacherName)
fun Schedule.toEntity() = ScheduleEntity(id, subjectId, dayOfWeek, startTime, endTime, room, teacherName)

fun TaskEntity.toDomain() = Task(id, subjectId, title, description, givenDate, deadline, status)
fun Task.toEntity() = TaskEntity(id, subjectId, title, description, givenDate, deadline, status)

fun NoteEntity.toDomain() = Note(id, userId, subjectId, title, content, noteDate)
fun Note.toEntity() = NoteEntity(id, userId, subjectId, title, content, noteDate)
