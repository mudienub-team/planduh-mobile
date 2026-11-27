package com.hehe.planduh.domain.repository

import com.hehe.planduh.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun observeAll(userId: Int): Flow<List<Note>>
    fun observeBySubject(subjectId: Int): Flow<List<Note>>
    fun search(userId: Int, query: String): Flow<List<Note>>
    suspend fun save(note: Note): Int
    suspend fun delete(note: Note)
}
