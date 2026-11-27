package com.hehe.planduh.domain.repository

import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun observeName(userId: Int): Flow<String?>
    suspend fun saveName(userId: Int, name: String)
}
