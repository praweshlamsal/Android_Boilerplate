package com.example.founderapp.ui

import androidx.annotation.StringRes
import com.example.founderapp.base.BaseView
import com.example.founderapp.model.Post

interface PostView : BaseView {
    fun updatePosts(posts: List<Post>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()

}