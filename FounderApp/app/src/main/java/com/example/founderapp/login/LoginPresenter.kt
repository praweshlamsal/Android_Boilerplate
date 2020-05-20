package com.example.founderapp.login

import android.nfc.Tag
import android.util.Log
import com.example.founderapp.base.BasePresenter
import com.example.founderapp.base.PostApi
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class LoginPresenter(loginContractor: LoginContractor):BasePresenter<LoginContractor>(loginContractor) {



    @Inject
    lateinit var postApi: PostApi

    private var subscription: Disposable? = null



    fun requestLogin(email:String, password:String){
        loadPosts(email, password)
    }

    fun loadPosts(email: String,password: String){
        Log.d("checking","values"+email+" "+password)

        subscription = postApi.doLogin(email = email ,password = password)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnComplete{view.loginSuccess()}
            .subscribe({
                result -> System.out.println(result.toString())
                view.loginSuccess()
            },{
                error -> System.out.println(error)
                view.showError("Password not matched")
            })
    }


    override fun onViewDestroyed() {
        subscription?.dispose()
    }
}