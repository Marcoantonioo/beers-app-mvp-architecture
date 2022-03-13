package com.example.beersappmvparchitecture.presentation.base

import android.app.Dialog
import androidx.fragment.app.Fragment
import com.example.beersappmvparchitecture.utils.createProgressDialog
import com.example.beersappmvparchitecture.utils.showSnackBar

open class BaseFragment : Fragment(), BaseView {
    private var progressBar: Dialog? = null

    override fun showSnackBarMessage(message: String?) {
        message?.let { activity?.showSnackBar(it) }
    }

    override fun showLoading() {
        progressBar = activity?.createProgressDialog()
    }

    override fun dismissLoading() {
        progressBar?.dismiss()
    }
}