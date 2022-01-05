package com.appbusinesstasks.core.data.repository

import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.data.models.source.NetworkRepositorySource
import com.appbusinesstasks.core.data.service.NetworkService
import com.appbusinesstasks.core.db.models.User
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject
import javax.inject.Named

@ViewModelScoped
class NetworkRepository
@Inject constructor(
    private val networkService: NetworkService,
    @Named("auth_token") private val token : String
): NetworkRepositorySource {
    override suspend fun getTasks(): List<TaskApi> {
        return networkService.getTasksData(token = token)
    }

    override suspend fun getUsers(): List<User> {
        return networkService.getUserData(token = token)
    }

    override suspend fun getEmployees(): List<EmployeeApi> {
        return networkService.getEmployeesData(token = token)
    }

    override suspend fun getEnterprises(): List<EnterpriseApi> {
        return networkService.getEnterpriseData(token = token)
    }
}