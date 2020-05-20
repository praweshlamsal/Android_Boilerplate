package com.example.founderapp.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import com.example.founderapp.R
import com.example.founderapp.base.BaseActivity
import com.example.founderapp.databinding.ActivityPostBinding
import com.example.founderapp.model.UserLoginResponse
import com.example.founderapp.ui.PostActivity
import com.example.founderapp.ui.PostView
import com.google.android.material.snackbar.Snackbar

class LoginActivity:BaseActivity<LoginPresenter>(),LoginContractor {

    private lateinit var phone:String
    private lateinit var password:String
    private lateinit var phonenumber: EditText
    private lateinit var editpassword: EditText
    private lateinit var login_btn: Button
    private lateinit var snackbar:Snackbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        phonenumber = findViewById<EditText>(R.id.et_mobile_number)
        editpassword = findViewById<EditText>(R.id.et_password)
        login_btn = findViewById<Button>(R.id.btn_login)
        loginclick()
    }

    private fun loginclick() {
        login_btn.setOnClickListener(View.OnClickListener {
            if(validateclick()){
                phone = phonenumber.text.toString()
                password = editpassword.text.toString();
                presenter.requestLogin(phone,password)
            }
            else{

            }
        })
    }

    private fun validateclick():Boolean {
        return true
    }

    override fun getActivityContext(): Activity {
        return this
    }

    override fun instantiatePresenter(): LoginPresenter {
        return LoginPresenter(this)
    }


    override fun showError(error: String) {
        var relativeLayout:RelativeLayout = findViewById<RelativeLayout>(R.id.relativelayout)
        snackbar = Snackbar.make(relativeLayout,error,Snackbar.LENGTH_LONG)
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginSuccess() {
        val intent = Intent(this,PostActivity::class.java)
        startActivity(intent)
    }


}