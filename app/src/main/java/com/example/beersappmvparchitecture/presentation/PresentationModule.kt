package com.example.beersappmvparchitecture.presentation

import com.example.beersappmvparchitecture.presentation.beer.BeerContract
import com.example.beersappmvparchitecture.presentation.beer.BeerPresenter
import org.koin.dsl.module

object PresentationModule {
    val module = module {
        factory<BeerContract.Presenter> { (view : BeerContract.View) ->
            BeerPresenter(
                view = view,
                usecase = get()
            )
        }
    }
}