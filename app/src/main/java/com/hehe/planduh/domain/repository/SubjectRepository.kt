package com.hehe.planduh.domain.repository

import com.hehe.planduh.domain.model.Subject
import kotlinx.coroutines.flow.Flow

interface SubjectRepository {
    fun observeByPeriod(periodId: Int): Flow<List<Subject>>
    fun observeInActivePeriod(userId: Int): Flow<List<Subject>>
    suspend fun save(subject: Subject): Int
    suspend fun delete(subject: Subject)
}
