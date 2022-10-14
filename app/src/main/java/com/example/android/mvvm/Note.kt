package com.example.android.mvvm

import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * Created by Thinhvh on 14/10/2022.
 * Phone: 0398477967
 * Email: thinhvh.fpt@gmail.com
 */
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var content: String?=null,
)