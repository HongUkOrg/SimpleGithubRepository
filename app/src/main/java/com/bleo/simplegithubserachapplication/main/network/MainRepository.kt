package com.bleo.simplegithubserachapplication.main.network

import com.bleo.simplegithubserachapplication.main.model.GithubRepositoryModel
import io.reactivex.rxjava3.core.Single

class MainRepository {
    private val api = MainService.githubApi

    fun searchGithubRepos(query: String): Single<List<GithubRepositoryModel>> =
        api.searchRepos(query)
            .map {
                it.asJsonObject.getAsJsonArray("items")
                    .map { repo ->
                        MainService.gson.fromJson(repo, GithubRepositoryModel::class.java)!!
                    }
            }
}