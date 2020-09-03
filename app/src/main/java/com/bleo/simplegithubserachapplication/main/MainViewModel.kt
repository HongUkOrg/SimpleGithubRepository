package com.bleo.simplegithubserachapplication.main

import android.util.Log
import androidx.lifecycle.ViewModel
import com.bleo.simplegithubserachapplication.main.model.GithubRepositoryModel
import com.bleo.simplegithubserachapplication.main.network.MainRepository
import com.jakewharton.rxrelay3.BehaviorRelay
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class MainViewModel : ViewModel() {

    // MARK: - Properties
    private val mainRepository: MainRepository = MainRepository()
    private val disposable: CompositeDisposable = CompositeDisposable()
    private var searchText = ""
    val githubItemRelay: BehaviorRelay<List<GithubRepositoryModel>> = BehaviorRelay.createDefault(emptyList())

    fun searchRepo() {
        mainRepository.searchGithubRepos(searchText)
            .subscribe({ models ->
                githubItemRelay.accept(models)
            }, {
                Log.e("bleo", "searchRepo: ERROR $it")
            })
            .addTo(disposable)
    }

    fun searchTextChanged(searchText: CharSequence?) {
        this.searchText = searchText.toString()
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }
}