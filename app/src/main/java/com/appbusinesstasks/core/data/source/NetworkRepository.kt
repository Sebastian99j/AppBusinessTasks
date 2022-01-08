package com.appbusinesstasks.core.data.source

import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.ResponseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.db.models.User

interface NetworkRepositorySource {
    suspend fun getTasks(): List<TaskApi>
    suspend fun getUsers(): List<User>
    suspend fun getEmployees(): List<EmployeeApi>
    suspend fun getEnterprises(): List<EnterpriseApi>
    suspend fun validateUser(user: User): ResponseApi

    suspend fun deleteTask(id: Long)
    suspend fun addTask(taskApi: TaskApi)
    suspend fun updateTask(taskApi: TaskApi)
}