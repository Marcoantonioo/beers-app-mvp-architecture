package com.example.beersappmvparchitecture.presentation.base

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.beersappmvparchitecture.R
import com.example.beersappmvparchitecture.utils.createProgressDialog
import com.example.beersappmvparchitecture.utils.gone
import com.example.beersappmvparchitecture.utils.showSnackBar
import com.example.beersappmvparchitecture.utils.visible
import com.google.android.material.snackbar.Snackbar

open class BaseActivity : AppCompatActivity(), BaseView {
    private var progressBar: Dialog? = null

    override fun showSnackBarMessage(message: String?) {
        message?.let {
            showSnackBar(it)
        }
    }

    override fun showLoading() {
        progressBar = createProgressDialog()
    }

    override fun dismissLoading() {
        progressBar?.dismiss()
    }
}