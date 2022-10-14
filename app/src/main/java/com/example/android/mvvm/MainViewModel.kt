package com.example.android.mvvm

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


/**
 * Created by Thinhvh on 14/10/2022.
 * Phone: 0398477967
 * Email: thinhvh.fpt@gmail.com
 */
class MainViewModel(application: android.app.Application) : AndroidViewModel(application) {
    private val noteDao = AppDatabase.getInstance(application).getNoteDao()
    var notesLiveData: LiveData<List<Note>>? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            notesLiveData = noteDao.getNotesAsync()
        }
    }

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            noteDao.addNote(note)
        }
    }
}