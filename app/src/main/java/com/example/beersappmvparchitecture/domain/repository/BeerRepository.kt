package com.example.beersappmvparchitecture.domain.repository

import com.example.beersappmvparchitecture.domain.model.BeerDomain
import kotlinx.coroutines.flow.Flow

interface BeerRepository {
    fun loadAllPaged(page: Int) : Flow<Result<List<BeerDomain>>>
}