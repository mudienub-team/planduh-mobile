package com.hehe.planduh.data.repository

import com.hehe.planduh.data.local.dao.NoteDao
import com.hehe.planduh.data.local.mapper.toDomain
import com.hehe.planduh.data.local.mapper.toEntity
import com.hehe.planduh.domain.model.Note
import com.hehe.planduh.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(private val dao: NoteDao) : NoteRepository {
    override fun observeAll(userId: Int): Flow<List<Note>> =
        dao.observeAll(userId).map { list -> list.map { it.toDomain() } }

    override fun observeBySubject(subjectId: Int): Flow<List<Note>> =
        dao.observeBySubject(subjectId).map { list -> list.map { it.toDomain() } }

    override fun search(userId: Int, query: String): Flow<List<Note>> =
        dao.search(userId, query).map { list -> list.map { it.toDomain() } }

    override suspend fun save(note: Note): Int = dao.upsert(note.toEntity()).toInt()
    override suspend fun delete(note: Note) = dao.delete(note.toEntity())
}
