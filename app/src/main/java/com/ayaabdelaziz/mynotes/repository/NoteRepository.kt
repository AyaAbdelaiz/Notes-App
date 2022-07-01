package com.ayaabdelaziz.mynotes.repository

import androidx.lifecycle.LiveData
import com.ayaabdelaziz.mynotes.data.dao.NotesDao
import com.ayaabdelaziz.mynotes.model.Note

class NoteRepository(var notesDao: NotesDao) {


    suspend fun insertNote(note: Note) =
        notesDao.insertNote(note)


    suspend fun updateNote(note: Note) =
        notesDao.updateNote(note)


    fun getNotes(): LiveData<List<Note>> =
        notesDao.getNotes()


    suspend fun deleteSpecificNote(id: Int) =
        notesDao.deleteSpecificNote(id)


    suspend fun deleteNote(note: Note) =
        notesDao.deleteNote(note)


}