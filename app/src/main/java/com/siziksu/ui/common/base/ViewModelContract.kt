package com.siziksu.ui.common.base

import androidx.lifecycle.AndroidViewModel
import org.koin.standalone.StandAloneContext.getKoin

abstract class ViewModelContract : AndroidViewModel(getKoin().koinContext.get()) {

    abstract fun showProgress()

    abstract fun hideProgress()

    abstract fun onDestroy()
}
