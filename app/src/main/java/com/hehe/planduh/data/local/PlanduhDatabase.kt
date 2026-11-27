package com.hehe.planduh.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hehe.planduh.data.local.converter.Converters
import com.hehe.planduh.data.local.dao.NoteDao
import com.hehe.planduh.data.local.dao.PeriodDao
import com.hehe.planduh.data.local.dao.ScheduleDao
import com.hehe.planduh.data.local.dao.SubjectDao
import com.hehe.planduh.data.local.dao.TaskDao
import com.hehe.planduh.data.local.dao.UserDao
import com.hehe.planduh.data.local.entity.NoteEntity
import com.hehe.planduh.data.local.entity.PeriodEntity
import com.hehe.planduh.data.local.entity.ScheduleEntity
import com.hehe.planduh.data.local.entity.SubjectEntity
import com.hehe.planduh.data.local.entity.TaskEntity
import com.hehe.planduh.data.local.entity.UserEntity

@Database(
    entities = [
        UserEntity::class,
        PeriodEntity::class,
        SubjectEntity::class,
        ScheduleEntity::class,
        TaskEntity::class,
        NoteEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(Converters::class)
abstract class PlanduhDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun periodDao(): PeriodDao
    abstract fun subjectDao(): SubjectDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun taskDao(): TaskDao
    abstract fun noteDao(): NoteDao

    companion object {
        const val NAME = "planduh.db"
        const val DEFAULT_USER_ID = 1

        fun create(context: Context): PlanduhDatabase =
            Room.databaseBuilder(context.applicationContext, PlanduhDatabase::class.java, NAME)
                .addCallback(SeedCallback)
                .build()
    }

    /** The app has no login yet, so a single local user (id = 1) is created together with the database. */
    private object SeedCallback : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            db.execSQL("INSERT INTO users (id, name) VALUES ($DEFAULT_USER_ID, 'Rina')")
        }
    }
}
