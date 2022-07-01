package com.ayaabdelaziz.mynotes.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
class Note {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
    var title: String? = null
    var subTitle: String? = null
    var date: String? = null
    var noteDesc: String? = null
    var color: String? = null
//    val image: String,
//    val web: String,
//    val color: String

}
