package com.example.beersappmvparchitecture.presentation.beer

import com.example.beersappmvparchitecture.domain.model.BeerDomain
import com.example.beersappmvparchitecture.domain.usecase.ILoadAllPagedBeerUseCase
import com.example.beersappmvparchitecture.presentation.beer.model.BeerView
import com.example.beersappmvparchitecture.utils.CoroutinesHelper

class BeerPresenter(
    private val view: BeerContract.View,
    private val usecase: ILoadAllPagedBeerUseCase
) : BeerContract.Presenter {
    private var currentPage = INITIAL_PAGE

    private val oldList = mutableListOf<BeerView>()

    override fun loadMore() {
        loadAll()
    }

    override fun loadAll() {
        CoroutinesHelper.createCoroutineScope(
            usecase = usecase.execute(++currentPage),
            onStart = { view.showLoading() },
            onCompletion = { view.dismissLoading() },
            onSuccess = ::onSuccess,
            onFailure = ::onFailure
        )
    }

    override fun onSuccess(value: List<BeerDomain>) {
        val newList = value.map { it.toView() }
        oldList.addAll(newList)

        view.updateList(oldList)

        view.dismissLoading()
        if (value.isEmpty()) {
            view.showError("Nenhum dado retornado")
        }
    }

    override fun onFailure(error: Throwable) {
        view.dismissLoading()
        view.showError("Não conseguimos comunicação com a API, por favor tente novamente")
        view.showSnackBarMessage(error.message)
    }

    override fun initView() {
        view.onClickTryAgain()
        view.setAdapter()
        view.configureRecyclerView()
    }

    companion object {
        const val INITIAL_PAGE = 1
    }
}
