package com.ayaabdelaziz.mynotes.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ayaabdelaziz.mynotes.model.Note

@Dao
interface NotesDao {


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Query("SELECT * FROM notes ORDER BY id ASC")
    fun getNotes(): LiveData<List<Note>>

    @Update
    suspend fun updateNote(note: Note)

    @Query("DELETE FROM notes WHERE id =:id ")
    suspend fun deleteSpecificNote(id: Int)

    @Delete
    suspend fun deleteNote(note: Note)


}