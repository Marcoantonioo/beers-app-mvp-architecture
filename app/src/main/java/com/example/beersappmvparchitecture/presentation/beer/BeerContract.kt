package com.example.beersappmvparchitecture.presentation.beer

import com.example.beersappmvparchitecture.presentation.base.BaseView
import com.example.beersappmvparchitecture.presentation.beer.model.BeerView

object BeerContract {
    interface View : BaseView {
        fun updateList(list: List<BeerView>)
        fun onClickTryAgain()
        fun showError(message: String)
    }

    interface Presenter {
        fun loadAll()
        fun initView()
    }
}