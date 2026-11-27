package com.hehe.planduh.domain.repository

import com.hehe.planduh.domain.model.Period
import kotlinx.coroutines.flow.Flow

interface PeriodRepository {
    fun observeAll(userId: Int): Flow<List<Period>>
    fun observeActive(userId: Int): Flow<Period?>
    /** Inserts when id == 0, otherwise updates. Returns the row id. */
    suspend fun save(period: Period): Int
    /** Makes [periodId] the only active period of the user. */
    suspend fun setActive(userId: Int, periodId: Int)
    suspend fun delete(period: Period)
}
