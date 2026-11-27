package com.hehe.planduh.data.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.hehe.planduh.domain.model.TaskStatus
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(
    tableName = "tasks",
    foreignKeys = [
        ForeignKey(
            entity = SubjectEntity::class,
            parentColumns = ["id"],
            childColumns = ["subject_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [Index("subject_id"), Index("status"), Index("deadline")],
)
data class TaskEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "subject_id") val subjectId: Int,
    val title: String,
    val description: String? = null,
    @ColumnInfo(name = "given_date") val givenDate: LocalDate? = null,
    val deadline: LocalDateTime? = null,
    /** Stored as enum name: NOT_DONE / DONE. */
    val status: TaskStatus = TaskStatus.NOT_DONE,
)
