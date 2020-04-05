package com.example.igdb.external.helper

import android.app.Activity
import android.app.ProgressDialog
import com.example.igdb.R
import timber.log.Timber

class DialogHelper(private val activity: Activity) {
    private var progressDialog: ProgressDialog? = null

    fun showFailedDialog() {
        Timber.d(activity.getString(R.string.show_failed_dialog))
    }
    
    fun showSuccessDialog() {
        Timber.d(activity.getString(R.string.show_success_dialog))
    }
    
    fun showConfirmationDialog() {
        Timber.d(activity.getString(R.string.show_confirmation_dialog))
    }

    fun showProgressDialog(message: String) {
        if (!activity.isFinishing) {
            progressDialog = ProgressDialog(activity).apply {
                setMessage(message)
                setCancelable(false)
                show()
            }
        }
    }

    fun hideProgressDialog() {
        if (!activity.isFinishing) {
            progressDialog?.apply {
                dismiss()
            }
        }
    }
}