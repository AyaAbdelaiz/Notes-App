package com.ayaabdelaziz.mynotes.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ayaabdelaziz.mynotes.data.dao.NotesDao
import com.ayaabdelaziz.mynotes.model.Note

@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNotesDao(): NotesDao

    companion object {
        @Volatile
        var instance: NoteDatabase? = null

        fun getDatabase(context: Context): NoteDatabase {
            val tempInstance = instance
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val Instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "user_datavbase"
                ).build()
                instance = Instance
                return Instance
            }

        }
    }
}