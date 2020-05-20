package com.example.founderapp.ui

import com.example.founderapp.R
import com.example.founderapp.base.BasePresenter
import com.example.founderapp.base.PostApi
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class PostPresenter (postView: PostView):BasePresenter<PostView>(postView){

    @Inject
    lateinit var postApi: PostApi

    private var subscription:Disposable? = null

    override fun onViewCreated() {
        loadPosts()
    }

    fun loadPosts() {
        view.showLoading()
        subscription = postApi.getPosts()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnTerminate{view.hideLoading()}
            .subscribe(
                {postList -> view.updatePosts(postList)},
                {view.showError(R.string.unknown_error)}
            )
    }

    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}