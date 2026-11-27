package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.UserDao
import com.hehe.planduh.data.local.entity.UserEntity
import com.hehe.planduh.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(private val dao: UserDao) : UserRepository {
    override fun observeName(userId: Int): Flow<String?> = dao.observe(userId).map { it?.name }
    override suspend fun saveName(userId: Int, name: String) {
        dao.upsert(UserEntity(id = userId, name = name))
    }
}
