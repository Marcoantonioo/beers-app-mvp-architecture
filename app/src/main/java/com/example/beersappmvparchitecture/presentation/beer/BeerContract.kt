package com.example.beersappmvparchitecture.presentation.beer

import com.example.beersappmvparchitecture.domain.model.BeerDomain
import com.example.beersappmvparchitecture.presentation.base.BasePresenter
import com.example.beersappmvparchitecture.presentation.base.BaseView
import com.example.beersappmvparchitecture.presentation.beer.model.BeerView

object BeerContract {
    interface View : BaseView {
        fun updateList(list: List<BeerView>)
        fun onClickTryAgain()
        fun showError(message: String)
        fun setAdapter()
        fun configureRecyclerView()
    }

    interface Presenter : BasePresenter<List<BeerDomain>> {
        fun loadAll()
        fun loadMore()
        fun initView()
    }
}