package com.example.founderapp.login

import androidx.annotation.StringRes
import com.example.founderapp.base.BaseView
import com.example.founderapp.model.UserLoginResponse

interface LoginContractor : BaseView {

    fun showError(error: String)
    fun loginSuccess();
    fun showError(@StringRes errorResId: Int) {
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}