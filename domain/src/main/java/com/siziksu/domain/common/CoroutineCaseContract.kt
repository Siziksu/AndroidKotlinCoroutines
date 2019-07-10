package com.siziksu.domain.common

interface CoroutineCaseContract<R, P> {

    suspend fun func(params: P): R

    fun run(success: (R) -> Unit, error: (Throwable) -> Unit, params: P)

    fun onDestroy()
}
