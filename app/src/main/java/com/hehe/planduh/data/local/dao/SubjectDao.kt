package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.SubjectEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SubjectDao {
    @Query("SELECT * FROM subjects WHERE period_id = :periodId ORDER BY name")
    fun observeByPeriod(periodId: Int): Flow<List<SubjectEntity>>

    @Query(
        """
        SELECT s.* FROM subjects s
        INNER JOIN periods p ON p.id = s.period_id
        WHERE p.user_id = :userId AND p.is_active = 1
        ORDER BY s.name
        """,
    )
    fun observeInActivePeriod(userId: Int): Flow<List<SubjectEntity>>

    @Upsert
    suspend fun upsert(subject: SubjectEntity): Long

    @Delete
    suspend fun delete(subject: SubjectEntity)
}
