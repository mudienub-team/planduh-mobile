package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.PeriodDao
import com.hehe.planduh.data.local.mapper.toDomain
import com.hehe.planduh.data.local.mapper.toEntity
import com.hehe.planduh.domain.model.Period
import com.hehe.planduh.domain.repository.PeriodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PeriodRepositoryImpl(private val dao: PeriodDao) : PeriodRepository {
    override fun observeAll(userId: Int): Flow<List<Period>> =
        dao.observeAll(userId).map { list -> list.map { it.toDomain() } }

    override fun observeActive(userId: Int): Flow<Period?> =
        dao.observeActive(userId).map { it?.toDomain() }

    override suspend fun save(period: Period): Int = dao.upsert(period.toEntity()).toInt()
    override suspend fun setActive(userId: Int, periodId: Int) = dao.setActive(userId, periodId)
    override suspend fun delete(period: Period) = dao.delete(period.toEntity())
}
