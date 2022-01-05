package com.appbusinesstasks.core.data.models.api

import com.google.gson.annotations.SerializedName

data class UserApi(
    @SerializedName("id")
    var id: Long,
    @SerializedName("name")
    var name: String,
    @SerializedName("password")
    var password: String
)
