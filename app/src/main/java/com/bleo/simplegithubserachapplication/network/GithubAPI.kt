package com.bleo.simplegithubserachapplication.network

import com.google.gson.JsonElement
import io.reactivex.rxjava3.core.Single
import retrofit2.http.*

interface GithubAPI {

    @GET("search/repositories")
    fun searchRepos(
        @Query("q") search: String
    ): Single<JsonElement>
}