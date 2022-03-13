package com.example.beersappmvparchitecture.presentation.base

interface BaseView {
    fun showSnackBarMessage(message: String?)
    fun showLoading()
    fun dismissLoading()
}