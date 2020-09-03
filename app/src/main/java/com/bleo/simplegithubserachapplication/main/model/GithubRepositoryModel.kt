package com.bleo.simplegithubserachapplication.main.model

import com.google.gson.annotations.SerializedName

data class GithubRepositoryModel(
    val name: String,
    val description: String,
    @SerializedName("owner")
    val owner: User,
    var star: Boolean = false
)