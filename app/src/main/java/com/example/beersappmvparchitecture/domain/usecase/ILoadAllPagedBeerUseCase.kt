package com.example.beersappmvparchitecture.domain.usecase

import com.example.beersappmvparchitecture.domain.model.BeerDomain
import kotlinx.coroutines.flow.Flow

interface ILoadAllPagedBeerUseCase {
    fun execute(page: Int) : Flow<Result<List<BeerDomain>>>
}