package com.hehe.planduh.domain.repository

import com.hehe.planduh.domain.model.Schedule
import kotlinx.coroutines.flow.Flow
import java.time.DayOfWeek

interface ScheduleRepository {
    fun observeAll(): Flow<List<Schedule>>
    fun observeByDay(day: DayOfWeek): Flow<List<Schedule>>
    fun observeBySubject(subjectId: Int): Flow<List<Schedule>>
    suspend fun save(schedule: Schedule): Int
    suspend fun delete(schedule: Schedule)
}
