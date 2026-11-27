package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.SubjectDao
import com.hehe.planduh.data.local.mapper.toDomain
import com.hehe.planduh.data.local.mapper.toEntity
import com.hehe.planduh.domain.model.Subject
import com.hehe.planduh.domain.repository.SubjectRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubjectRepositoryImpl(private val dao: SubjectDao) : SubjectRepository {
    override fun observeByPeriod(periodId: Int): Flow<List<Subject>> =
        dao.observeByPeriod(periodId).map { list -> list.map { it.toDomain() } }

    override fun observeInActivePeriod(userId: Int): Flow<List<Subject>> =
        dao.observeInActivePeriod(userId).map { list -> list.map { it.toDomain() } }

    override suspend fun save(subject: Subject): Int = dao.upsert(subject.toEntity()).toInt()
    override suspend fun delete(subject: Subject) = dao.delete(subject.toEntity())
}
