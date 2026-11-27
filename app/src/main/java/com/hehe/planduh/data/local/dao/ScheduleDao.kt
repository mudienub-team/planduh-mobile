package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.ScheduleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedules ORDER BY day_of_week, start_time")
    fun observeAll(): Flow<List<ScheduleEntity>>

    /** [dayOfWeek] is the ISO value 1-7 (1 = Monday). */
    @Query("SELECT * FROM schedules WHERE day_of_week = :dayOfWeek ORDER BY start_time")
    fun observeByDay(dayOfWeek: Int): Flow<List<ScheduleEntity>>

    @Query("SELECT * FROM schedules WHERE subject_id = :subjectId ORDER BY day_of_week, start_time")
    fun observeBySubject(subjectId: Int): Flow<List<ScheduleEntity>>

    @Upsert
    suspend fun upsert(schedule: ScheduleEntity): Long

    @Delete
    suspend fun delete(schedule: ScheduleEntity)
}
