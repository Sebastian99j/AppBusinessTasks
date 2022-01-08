package com.appbusinesstasks.core.data.models.api

import com.google.gson.annotations.SerializedName

data class TaskApi(
    @SerializedName("id")
    var id: Long?,
    @SerializedName("name")
    var name: String,
    @SerializedName("description")
    var description: String,
    @SerializedName("start_date")
    var start_date: String,
    @SerializedName("end_date")
    var end_date: String,
    @SerializedName("priority")
    var priority: String,
    @SerializedName("status")
    var status: String,
    @SerializedName("open")
    var open: String,
    @SerializedName("completion")
    var completion: Int?,
    @SerializedName("comments")
    var comments: List<String>?
)
