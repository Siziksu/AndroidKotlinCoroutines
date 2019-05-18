package com.siziksu.ui.view.common.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

abstract class PresenterContract : CoroutineScope {

    private val errorHandler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }

    internal var coroutineDispatcher: CoroutineDispatcher = Main

    override val coroutineContext: CoroutineContext by lazy { coroutineDispatcher + errorHandler + SupervisorJob() }

    abstract fun onError(error: Throwable)

    internal open fun onDestroy() {
        coroutineContext.cancel()
    }
}
