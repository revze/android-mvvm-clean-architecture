package com.example.belajardagger.external.helper

import android.app.Activity
import com.example.belajardagger.R
import timber.log.Timber

class DialogHelper(private val activity: Activity) {
    fun showFailedDialog() {
        Timber.d(activity.getString(R.string.show_failed_dialog))
    }
    
    fun showSuccessDialog() {
        Timber.d(activity.getString(R.string.show_success_dialog))
    }
    
    fun showConfirmationDialog() {
        Timber.d(activity.getString(R.string.show_confirmation_dialog))
    }
}