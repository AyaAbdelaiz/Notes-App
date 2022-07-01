package com.ayaabdelaziz.mynotes.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.ayaabdelaziz.mynotes.data.database.NoteDatabase
import com.ayaabdelaziz.mynotes.model.Note
import com.ayaabdelaziz.mynotes.repository.NoteRepository
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NoteViewModel(application: Application) : AndroidViewModel(application) {

    private var noteRepository: NoteRepository
    var notes: LiveData<List<Note>>

    init {
        val noteDao = NoteDatabase.getDatabase(application).getNotesDao()
        noteRepository = NoteRepository(noteDao)
        notes = noteRepository.getNotes()
        Log.d("Room", ":${notes?.value?.forEach { 
            it.title
        }} ")
    }

    fun insertNote(note: Note) {
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    }

    fun updateNote(note: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }
    }

//    fun getNote(): LiveData<List<Note>> {
//        viewModelScope.launch {
//            notes = noteRepository.getNotes()
//        }
//        return notes
//    }

    fun deleteSpcificNote(id: Int) {
        viewModelScope.launch {
            noteRepository.deleteSpecificNote(id)
        }
    }

    fun deleteNote(note: Note) {
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    }


}