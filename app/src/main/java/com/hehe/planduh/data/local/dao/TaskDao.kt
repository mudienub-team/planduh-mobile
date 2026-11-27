package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.TaskEntity
import com.hehe.planduh.domain.model.TaskStatus
import kotlinx.coroutines.flow.Flow

@Dao
interface TaskDao {
    // Tasks without a deadline go last.
    @Query("SELECT * FROM tasks ORDER BY deadline IS NULL, deadline")
    fun observeAll(): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE status = :status ORDER BY deadline IS NULL, deadline")
    fun observeByStatus(status: TaskStatus): Flow<List<TaskEntity>>

    @Query("SELECT * FROM tasks WHERE subject_id = :subjectId ORDER BY deadline IS NULL, deadline")
    fun observeBySubject(subjectId: Int): Flow<List<TaskEntity>>

    @Upsert
    suspend fun upsert(task: TaskEntity): Long

    @Query("UPDATE tasks SET status = :status WHERE id = :taskId")
    suspend fun setStatus(taskId: Int, status: TaskStatus)

    @Delete
    suspend fun delete(task: TaskEntity)
}
