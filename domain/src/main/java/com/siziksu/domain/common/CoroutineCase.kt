package com.siziksu.domain.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

abstract class CoroutineCase<R, P> : CoroutineScope, CoroutineCaseContract<R, P> {

    override val coroutineContext: CoroutineContext by lazy { coroutineDispatcher + job }

    private var job = Job()
    private val coroutineDispatcher: CoroutineDispatcher = Dispatchers.Main

    override fun run(success: (R) -> Unit, error: (Throwable) -> Unit, params: P) {
        launch {
            try {
                success(func(params))
            } catch (e: Throwable) {
                error(e)
            }
        }
    }

    override fun onDestroy() = job.cancel()
}
