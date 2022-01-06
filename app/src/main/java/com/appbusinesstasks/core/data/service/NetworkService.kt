package com.appbusinesstasks.core.data.service

import com.appbusinesstasks.core.data.models.api.EmployeeApi
import com.appbusinesstasks.core.data.models.api.EnterpriseApi
import com.appbusinesstasks.core.data.models.api.ResponseApi
import com.appbusinesstasks.core.data.models.api.TaskApi
import com.appbusinesstasks.core.db.models.User
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface NetworkService {
    @GET("api/tasks")
    suspend fun getTasksData(
        @Header("Authorization") token: String
    ): List<TaskApi>

    @GET("api/users")
    suspend fun getUserData(
        @Header("Authorization") token: String
    ): List<User>

    @GET("api/employees")
    suspend fun getEmployeesData(
        @Header("Authorization") token: String
    ): List<EmployeeApi>

    @GET("api/enterprises")
    suspend fun getEnterpriseData(
        @Header("Authorization") token: String
    ): List<EnterpriseApi>

    @POST("/api/validate")
    suspend fun authorization(
        @Header("Authorization") token: String,
        @Body user: User
    ): ResponseApi
}