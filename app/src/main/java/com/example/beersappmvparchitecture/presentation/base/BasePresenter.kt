package com.example.beersappmvparchitecture.presentation.base

interface BasePresenter<T> {
    fun onSuccess(value: T)
    fun onFailure(error: Throwable)
}