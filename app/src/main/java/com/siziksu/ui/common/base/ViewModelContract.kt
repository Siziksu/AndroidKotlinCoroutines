package com.siziksu.ui.common.base

import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import org.koin.standalone.StandAloneContext.getKoin
import kotlin.coroutines.CoroutineContext

abstract class ViewModelContract : AndroidViewModel(getKoin().koinContext.get()), CoroutineScope {

    private val errorHandler = CoroutineExceptionHandler { _, throwable -> onError(throwable) }

    private var coroutineDispatcher: CoroutineDispatcher = Main

    override val coroutineContext: CoroutineContext by lazy { coroutineDispatcher + errorHandler + SupervisorJob() }

    abstract fun onError(error: Throwable)

    abstract fun showProgress()

    abstract fun hideProgress()

    internal open fun onDestroy() {
        coroutineContext.cancel()
    }
}
