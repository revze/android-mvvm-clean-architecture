package com.example.login.presentation.loginemail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.igdb.external.extensions.longToast
import com.example.igdb.external.helper.DialogHelper
import com.example.igdb.presentation.base.BaseViewModelFactory
import com.example.login.R
import com.example.login.di.Injector
import kotlinx.android.synthetic.main.activity_login2.*
import javax.inject.Inject

class LoginEmailActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: BaseViewModelFactory<LoginEmailViewModel>

    @Inject
    lateinit var dialogHelper: DialogHelper

    private lateinit var viewModel: LoginEmailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        Injector.create(this).inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        setupViewModel()

        btn_login.setOnClickListener {
            viewModel.loginEmail(edt_email.text.toString(), edt_password.text.toString())
        }
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[LoginEmailViewModel::class.java]
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
