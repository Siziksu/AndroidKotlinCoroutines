package com.siziksu.domain.common.base

interface UseCaseContract<P, R> {

    suspend fun execute(params: P): R
}