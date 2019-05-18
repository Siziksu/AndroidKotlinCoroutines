package com.siziksu.ui.view.main

import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.domain.usecase.user.GetUserContract.Param
import com.siziksu.ui.view.common.utils.Logs
import com.siziksu.ui.view.mapper.UserDomainMapper
import kotlinx.coroutines.launch

class MainPresenter(
    private val view: MainContract.View?,
    private val getUser: GetUserContract,
    private val userDomainMapper: UserDomainMapper
) : MainContract.Presenter<MainContract.View>() {

    override fun getUser() {
        launch {
            onSuccess(getUser.execute(Param(2)))
        }
    }

    override fun onError(error: Throwable) {
        view?.showError("Something went wrong")
        Logs.error("Error: " + error.message)
    }

    private fun onSuccess(userDomain: UserDomain) {
        view?.showUser(userDomainMapper.map(userDomain))
    }
}
