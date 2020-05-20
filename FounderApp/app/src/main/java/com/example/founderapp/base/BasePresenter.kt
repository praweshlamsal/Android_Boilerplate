package com.example.founderapp.base

import com.example.founderapp.injection.component.DaggerPresenterInjector
import com.example.founderapp.injection.component.PresenterInjector
import com.example.founderapp.injection.module.ContextModule
import com.example.founderapp.injection.module.NetworkModule
import com.example.founderapp.login.LoginPresenter
import com.example.founderapp.ui.PostPresenter


abstract class BasePresenter<out V : BaseView>(protected val view: V) {


    private val injector:PresenterInjector = DaggerPresenterInjector
        .builder()
        .baseView(view)
        .contextModule(ContextModule)
        .networkModule(NetworkModule)
        .build()


    init {
        inject()
    }

    open fun onViewCreated() {}


    open fun onViewDestroyed() {}


    private fun inject() {
        when(this){
            is PostPresenter -> injector.inject(this)
            is LoginPresenter -> injector.injectlogin(this)
        }
    }
}