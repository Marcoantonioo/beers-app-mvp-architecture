package com.example.beersappmvparchitecture.data.repository

import com.example.beersappmvparchitecture.data.remote.service.BeerRetrofitService
import com.example.beersappmvparchitecture.domain.model.BeerDomain
import com.example.beersappmvparchitecture.domain.repository.BeerRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.delay
import java.lang.Exception

class BeerRepositoryImpl(
    private val service: BeerRetrofitService
) : BeerRepository {
    override fun loadAllPaged(page: Int): Flow<Result<List<BeerDomain>>> {
        return flow {
            try {
                delay(DELAY)
                val result = service.loadAllPaged(page).map { it.toModel() }
                emit(Result.success(result))
            } catch (ex: Exception) {
                ex.printStackTrace()
                emit(Result.failure(Exception("Não foi possível se comunicar com a API: ${ex.message}")))
            }
        }
    }

    companion object {
        const val DELAY = 3000L
    }
}