package com.example.beersappmvparchitecture.data

import com.example.beersappmvparchitecture.data.repository.BeerRepositoryImpl
import com.example.beersappmvparchitecture.domain.repository.BeerRepository
import com.example.beersappmvparchitecture.utils.Constants
import org.koin.dsl.module

object DataModule {
    val module = module {
        factory<BeerRepository> { BeerRepositoryImpl(service = get()) }

        single { RetrofitConfig.providerBeerRetrofitService(retrofit = get()) }

        single {
            RetrofitConfig.provideRetrofit(
                okHttpClient = get(),
                url = Constants.BASE_URL
            )
        }

        single { RetrofitConfig.provideOkHttpClient() }
    }
}
