package com.bleo.simplegithubserachapplication.network

import com.bleo.simplegithubserachapplication.model.GithubRepositoryModel
import io.reactivex.rxjava3.core.Single

class TempRepository {
    private val api = TempService.githubApi

    fun searchGithubRepos(query: String): Single<List<GithubRepositoryModel>> =
        api.searchRepos(query)
            .map {
                it.asJsonObject.getAsJsonArray("items")
                    .map { repo ->
                        TempService.gson.fromJson(repo, GithubRepositoryModel::class.java)!!
                    }
            }
}