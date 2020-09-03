package com.bleo.simplegithubserachapplication.main.network

import com.bleo.simplegithubserachapplication.main.model.GithubRepositoryModel
import io.reactivex.Single

class MainRepository {
    private val api = APIManager.githubApi

    fun searchGithubRepos(query: String): Single<List<GithubRepositoryModel>> =
        api.searchRepos(query)
            .map {
                it.asJsonObject.getAsJsonArray("items")
                    .map { repo ->
                        APIManager.gson.fromJson(repo, GithubRepositoryModel::class.java)!!
                    }
            }
}