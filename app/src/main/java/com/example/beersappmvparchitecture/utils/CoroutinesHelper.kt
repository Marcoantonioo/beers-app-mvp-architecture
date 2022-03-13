package com.example.beersappmvparchitecture.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

object CoroutinesHelper {
    fun <T> createCoroutineScope(
        context: CoroutineContext = Dispatchers.Main,
        usecase: Flow<Result<T>>,
        onStart: (FlowCollector<Result<T>>) -> Unit ,
        onCompletion: (FlowCollector<Result<T>>) -> Unit ,
        onSuccess: (T) -> Unit,
        onFailure: (error: Throwable) -> Unit
    ) {
        CoroutineScope(context).launch {
            usecase.onStart {
                onStart.invoke(this)
            }.onCompletion {
                onCompletion.invoke(this)
            }.collect {
                it.fold(onSuccess, onFailure)
            }
        }
    }
}