package com.appbusinesstasks.core.data.repository

import com.appbusinesstasks.core.db.dao.UserDao
import com.appbusinesstasks.core.db.models.User
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class UserRepository
@Inject constructor(private val userDao: UserDao){

    val getAllUsers: Flow<List<User>> = userDao.getAllUsers()

    fun getSelectedUser(userId: Long): Flow<User> {
        return userDao.getSelectedUser(userId = userId)
    }

    suspend fun addUser(user: User){
        userDao.deleteAllUsers()
        userDao.addUser(user = user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user = user)
    }

    suspend fun deleteUser(user: User){
        userDao.deleteUser(user = user)
    }

    suspend fun deleteAllUsers() = userDao.deleteAllUsers()

    fun searchDatabase(searchQuery: String): Flow<List<User>>{
        return userDao.searchDatabase(searchQuery = searchQuery)
    }
}