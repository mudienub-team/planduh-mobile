package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.TaskDao
import com.hehe.planduh.data.local.mapper.toDomain
import com.hehe.planduh.data.local.mapper.toEntity
import com.hehe.planduh.domain.model.Task
import com.hehe.planduh.domain.model.TaskStatus
import com.hehe.planduh.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class TaskRepositoryImpl(private val dao: TaskDao) : TaskRepository {
    override fun observeAll(): Flow<List<Task>> =
        dao.observeAll().map { list -> list.map { it.toDomain() } }

    override fun observeByStatus(status: TaskStatus): Flow<List<Task>> =
        dao.observeByStatus(status).map { list -> list.map { it.toDomain() } }

    override fun observeBySubject(subjectId: Int): Flow<List<Task>> =
        dao.observeBySubject(subjectId).map { list -> list.map { it.toDomain() } }

    override suspend fun save(task: Task): Int = dao.upsert(task.toEntity()).toInt()
    override suspend fun setStatus(taskId: Int, status: TaskStatus) = dao.setStatus(taskId, status)
    override suspend fun delete(task: Task) = dao.delete(task.toEntity())
}
