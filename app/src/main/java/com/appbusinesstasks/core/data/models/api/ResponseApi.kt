package com.appbusinesstasks.core.data.models.api

import com.google.gson.annotations.SerializedName

data class ResponseApi(
    @SerializedName("status")
    var status: String
)
