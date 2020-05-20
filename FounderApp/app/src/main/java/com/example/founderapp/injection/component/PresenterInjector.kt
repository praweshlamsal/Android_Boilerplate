package com.example.founderapp.injection.component

import com.example.founderapp.base.BaseView
import com.example.founderapp.injection.module.ContextModule
import com.example.founderapp.injection.module.NetworkModule
import com.example.founderapp.login.LoginPresenter
import com.example.founderapp.ui.PostPresenter
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import javax.inject.Singleton

@Singleton
@Component(modules = [(ContextModule::class),(NetworkModule::class)])
interface PresenterInjector {

    fun inject(postPresenter: PostPresenter)
    fun injectlogin(loginPresenter: LoginPresenter)


    @Component.Builder
    interface Builder {
        fun build(): PresenterInjector
        fun networkModule(networkModule: NetworkModule): Builder
        fun contextModule(contextModule: ContextModule): Builder

        @BindsInstance
        fun baseView(baseView: BaseView): Builder
    }
}