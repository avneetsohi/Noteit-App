package com.example.noteit

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NotesTable")
class Note (@ColumnInfo(name = "TEXT")val text:String){
    @PrimaryKey(autoGenerate = true)var id=0
}