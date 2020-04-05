package com.example.login.presentation.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.external.constants.ActivityConstant
import com.example.igdb.external.extensions.longToast
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.login.R
import com.example.login.di.Injector
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<LoginViewModel>

    @Inject
    lateinit var dialogHelper: DialogHelper

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.create(this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        setupViewModel()

        btn_login_google.setOnClickListener {
            viewModel.loginGoogle("23452")
        }
        btn_login_facebook.setOnClickListener {
            viewModel.loginFacebook("124234")
        }
        btn_login_email.setOnClickListener {
            Intent(
                this,
                Class.forName(ActivityConstant.LoginActivity.ACTIVITY)
            ).also {
                startActivity(it)
            }
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginViewModel::class.java]
        viewModel.loadingLiveData.observe(this, Observer {
            if (it) {
                dialogHelper.showProgressDialog("Mohon tunggu")
            } else {
                dialogHelper.hideProgressDialog()
            }
        })
        viewModel.errorLiveData.observe(this, Observer {
            longToast(it)
        })
        viewModel.resultLiveData.observe(this, Observer {
            longToast(it)
        })
    }
}
