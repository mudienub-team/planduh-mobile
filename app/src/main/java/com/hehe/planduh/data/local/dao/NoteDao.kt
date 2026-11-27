package com.hehe.planduh.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.hehe.planduh.data.local.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes WHERE user_id = :userId ORDER BY note_date DESC, id DESC")
    fun observeAll(userId: Int): Flow<List<NoteEntity>>

    @Query("SELECT * FROM notes WHERE subject_id = :subjectId ORDER BY note_date DESC, id DESC")
    fun observeBySubject(subjectId: Int): Flow<List<NoteEntity>>

    @Query(
        """
        SELECT * FROM notes
        WHERE user_id = :userId AND (title LIKE '%' || :query || '%' OR content LIKE '%' || :query || '%')
        ORDER BY note_date DESC, id DESC
        """,
    )
    fun search(userId: Int, query: String): Flow<List<NoteEntity>>

    @Upsert
    suspend fun upsert(note: NoteEntity): Long

    @Delete
    suspend fun delete(note: NoteEntity)
}
