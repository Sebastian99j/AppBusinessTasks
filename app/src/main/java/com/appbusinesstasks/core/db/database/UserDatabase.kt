package com.appbusinesstasks.core.db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.appbusinesstasks.core.db.dao.UserDao
import com.appbusinesstasks.core.db.models.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {

    abstract fun userDao(): UserDao

}