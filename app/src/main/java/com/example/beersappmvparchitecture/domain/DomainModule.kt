package com.example.beersappmvparchitecture.domain

import com.example.beersappmvparchitecture.domain.usecase.ILoadAllPagedBeerUseCase
import com.example.beersappmvparchitecture.domain.usecase.LoadAllPagedBeerUsecase
import org.koin.dsl.module

object DomainModule {
    val module = module {
        factory<ILoadAllPagedBeerUseCase> { LoadAllPagedBeerUsecase(get()) }
    }
}