package com.example.beersappmvparchitecture.domain.usecase

import com.example.beersappmvparchitecture.domain.repository.BeerRepository

class LoadAllPagedBeerUsecase(
    private val repository: BeerRepository
) : ILoadAllPagedBeerUseCase{
    override fun execute(page: Int) = repository.loadAllPaged(page)
}