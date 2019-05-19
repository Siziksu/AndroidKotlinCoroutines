package com.siziksu.ui.view.detail

import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.domain.usecase.user.GetUserContract.Param
import com.siziksu.ui.common.utils.Logs
import com.siziksu.ui.mapper.UserDomainMapper
import kotlinx.coroutines.launch

class UserDetailPresenter(
    private val view: UserDetailContract.View?,
    private val getUser: GetUserContract,
    private val userDomainMapper: UserDomainMapper
) : UserDetailContract.Presenter<UserDetailContract.View>() {

    override fun getUser(artistId: Int?) {
        artistId?.let {
            launch {
                onSuccess(getUser.execute(Param(artistId)))
            }
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
