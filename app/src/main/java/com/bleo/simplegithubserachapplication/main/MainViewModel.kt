package com.bleo.simplegithubserachapplication.main

import androidx.lifecycle.ViewModel
import com.bleo.simplegithubserachapplication.model.GithubRepositoryModel
import com.bleo.simplegithubserachapplication.network.TempRepository
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class MainViewModel : ViewModel() {

    // MARK: - Properties
    private val mainRepository: TempRepository = TempRepository()
    private val disposable: CompositeDisposable = CompositeDisposable()
    private var searchText = ""

    val githubItemRelay: BehaviorRelay<List<GithubRepositoryModel>> = BehaviorRelay.createDefault(emptyList())

    // MARK: - Methods
    fun searchRepositories() {
        mainRepository.searchGithubRepos(searchText)
            .subscribe { models ->
                githubItemRelay.accept(models)
            }
            .addTo(disposable)
    }

    fun searchTextChanged(searchText: CharSequence?) {
        this.searchText = searchText.toString()
    }

    // MARK: - Deinit
    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}