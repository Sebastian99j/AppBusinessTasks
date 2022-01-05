package com.appbusinesstasks.core.data.models.source

import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.db.models.User

interface NetworkRepositorySource {
    suspend fun getTasks(): List<TaskApi>
    suspend fun getUsers(): List<User>
    suspend fun getEmployees(): List<EmployeeApi>
    suspend fun getEnterprises(): List<EnterpriseApi>
}