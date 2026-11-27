package com.hehe.planduh.domain.repository

import com.hehe.planduh.domain.model.Task
import com.hehe.planduh.domain.model.TaskStatus
import kotlinx.coroutines.flow.Flow

interface TaskRepository {
    fun observeAll(): Flow<List<Task>>
    fun observeByStatus(status: TaskStatus): Flow<List<Task>>
    fun observeBySubject(subjectId: Int): Flow<List<Task>>
    suspend fun save(task: Task): Int
    suspend fun setStatus(taskId: Int, status: TaskStatus)
    suspend fun delete(task: Task)
}
