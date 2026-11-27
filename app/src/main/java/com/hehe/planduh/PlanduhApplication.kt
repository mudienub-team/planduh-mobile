package com.hehe.planduh

import android.app.Application
import com.hehe.planduh.data.local.PlanduhDatabase
import com.hehe.planduh.data.repository.NoteRepositoryImpl
import com.hehe.planduh.data.repository.PeriodRepositoryImpl
import com.hehe.planduh.data.repository.ScheduleRepositoryImpl
import com.hehe.planduh.data.repository.SubjectRepositoryImpl
import com.hehe.planduh.data.repository.TaskRepositoryImpl
import com.hehe.planduh.data.repository.UserRepositoryImpl
import com.hehe.planduh.domain.repository.NoteRepository
import com.hehe.planduh.domain.repository.PeriodRepository
import com.hehe.planduh.domain.repository.ScheduleRepository
import com.hehe.planduh.domain.repository.SubjectRepository
import com.hehe.planduh.domain.repository.TaskRepository
import com.hehe.planduh.domain.repository.UserRepository

class PlanduhApplication : Application() {
    // Manual DI (lazy singletons). Swap for Hilt/Koin later if needed.
    private val database: PlanduhDatabase by lazy { PlanduhDatabase.create(this) }

    val userRepository: UserRepository by lazy { UserRepositoryImpl(database.userDao()) }
    val periodRepository: PeriodRepository by lazy { PeriodRepositoryImpl(database.periodDao()) }
    val subjectRepository: SubjectRepository by lazy { SubjectRepositoryImpl(database.subjectDao()) }
    val scheduleRepository: ScheduleRepository by lazy { ScheduleRepositoryImpl(database.scheduleDao()) }
    val taskRepository: TaskRepository by lazy { TaskRepositoryImpl(database.taskDao()) }
    val noteRepository: NoteRepository by lazy { NoteRepositoryImpl(database.noteDao()) }
}
