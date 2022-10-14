package com.example.android.mvvm

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


/**
 * Created by Thinhvh on 14/10/2022.
 * Phone: 0398477967
 * Email: thinhvh.fpt@gmail.com
 */
@Dao
abstract class NoteDao {
    @Query("SELECT * FROM Note")
    abstract fun getNotes() : List<Note>

    @Query("SELECT * FROM Note")
    abstract fun getNotesAsync() : LiveData<List<Note>>

    @Insert
    abstract fun addNote(note: Note)
}