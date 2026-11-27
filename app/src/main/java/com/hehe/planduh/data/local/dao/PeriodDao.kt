package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.PeriodEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class PeriodDao {
    @Query("SELECT * FROM periods WHERE user_id = :userId ORDER BY academic_year DESC, semester")
    abstract fun observeAll(userId: Int): Flow<List<PeriodEntity>>

    @Query("SELECT * FROM periods WHERE user_id = :userId AND is_active = 1 LIMIT 1")
    abstract fun observeActive(userId: Int): Flow<PeriodEntity?>

    @Upsert
    abstract suspend fun upsert(period: PeriodEntity): Long

    @Delete
    abstract suspend fun delete(period: PeriodEntity)

    @Query("UPDATE periods SET is_active = 0 WHERE user_id = :userId")
    protected abstract suspend fun deactivateAll(userId: Int)

    @Query("UPDATE periods SET is_active = 1 WHERE id = :periodId")
    protected abstract suspend fun activate(periodId: Int)

    /** Makes [periodId] the only active period of the user, atomically. */
    @Transaction
    open suspend fun setActive(userId: Int, periodId: Int) {
        deactivateAll(userId)
        activate(periodId)
    }
}
