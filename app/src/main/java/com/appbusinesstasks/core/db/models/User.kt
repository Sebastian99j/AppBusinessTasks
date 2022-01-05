package com.appbusinesstasks.core.db.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.appbusinesstasks.utils.Constants.DATABASE_TABLE

@Entity(tableName = DATABASE_TABLE)
data class User (
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var name: String,
    var password: String)
