package com.appbusinesstasks.core.data.models.api

import com.google.gson.annotations.SerializedName

data class EmployeeApi(
    @SerializedName("id")
    var id: Long,
    @SerializedName("user")
    var user: UserApi,
    @SerializedName("first_name")
    var first_name: String,
    @SerializedName("last_name")
    var last_name: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("age")
    var age: String,
    @SerializedName("tasks")
    var tasks: List<TaskApi>
)
