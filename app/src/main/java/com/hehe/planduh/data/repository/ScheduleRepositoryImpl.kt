package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.ScheduleDao
import com.hehe.planduh.data.local.mapper.toDomain
import com.hehe.planduh.data.local.mapper.toEntity
import com.hehe.planduh.domain.model.Schedule
import com.hehe.planduh.domain.repository.ScheduleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.DayOfWeek

class ScheduleRepositoryImpl(private val dao: ScheduleDao) : ScheduleRepository {
    override fun observeAll(): Flow<List<Schedule>> =
        dao.observeAll().map { list -> list.map { it.toDomain() } }

    override fun observeByDay(day: DayOfWeek): Flow<List<Schedule>> =
        dao.observeByDay(day.value).map { list -> list.map { it.toDomain() } }

    override fun observeBySubject(subjectId: Int): Flow<List<Schedule>> =
        dao.observeBySubject(subjectId).map { list -> list.map { it.toDomain() } }

    override suspend fun save(schedule: Schedule): Int = dao.upsert(schedule.toEntity()).toInt()
    override suspend fun delete(schedule: Schedule) = dao.delete(schedule.toEntity())
}
