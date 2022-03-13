package com.example.beersappmvparchitecture.presentation.beer

import com.example.beersappmvparchitecture.domain.model.BeerDomain
import com.example.beersappmvparchitecture.domain.usecase.ILoadAllPagedBeerUseCase
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

class BeerPresenter(
    private val view: BeerContract.View,
    private val usecase: ILoadAllPagedBeerUseCase
) : BeerContract.Presenter{
    private var currentPage = INITIAL_PAGE

    override fun loadAll() {
        CoroutineScope(Dispatchers.Main).launch {
           usecase.execute(++currentPage).onStart {
               view.showLoading()
           }.onCompletion {
               view.dismissLoading()
           }.collect {
               it.fold(::onSuccess, ::onFailure)
           }
        }
    }

    private fun onSuccess(beers: List<BeerDomain>) {
        view.updateList(beers.map { it.toView() })
        view.dismissLoading()
        if (beers.isEmpty()) {
            view.showError("Nenhum dado retornado")
        } else {
            view.showSnackBarMessage("Todos os Dados foram carregados")
        }
    }

    private fun onFailure(error: Throwable) {
        view.dismissLoading()
        view.showError("Não conseguimos comunicação com a API, por favor tente novamente")
        view.showSnackBarMessage(error.message)
    }

    override fun initView() {
        view.onClickTryAgain()
    }

    companion object {
        const val INITIAL_PAGE = 1
    }
}
