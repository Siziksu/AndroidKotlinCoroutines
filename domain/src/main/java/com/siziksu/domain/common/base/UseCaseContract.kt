package com.siziksu.domain.common.base

interface UseCaseContract<P, Any> {

    suspend fun execute(params: P): Any
}