package com.appbusinesstasks.core.data.models.api

import com.google.gson.annotations.SerializedName

data class EnterpriseApi(
    @SerializedName("id")
    var id: Long,
    @SerializedName("user")
    var user: UserApi,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("localization")
    var localization: String,
    @SerializedName("employees")
    var employees: List<EmployeeApi>
)
