package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM users WHERE id = :id")
    fun observe(id: Int): Flow<UserEntity?>

    @Upsert
    suspend fun upsert(user: UserEntity): Long
}
