package com.appbusinesstasks.core.db.dao

import androidx.room.*
import com.appbusinesstasks.core.db.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM user_table WHERE id= :userId")
    fun getSelectedUser(userId: Long): Flow<User>

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM user_table WHERE name LIKE :searchQuery OR password LIKE :searchQuery")
    fun searchDatabase(searchQuery: String): Flow<List<User>>
}