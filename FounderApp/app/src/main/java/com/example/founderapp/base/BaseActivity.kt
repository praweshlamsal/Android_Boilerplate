package com.example.founderapp.base

import kotlinx.android.synthetic.main.app_bar.*


import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_founder_landing.*


abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView,AppCompatActivity() {


    protected lateinit var presenter: P

    abstract fun getActivityContext(): Activity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()

    }


    protected abstract fun instantiatePresenter():P

    override fun getContext(): Context {
        return this
    }

}
