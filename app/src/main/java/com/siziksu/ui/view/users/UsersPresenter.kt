package com.siziksu.ui.view.users

import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUsersContract
import com.siziksu.ui.common.utils.Logs
import com.siziksu.ui.mapper.UserDomainMapper
import kotlinx.coroutines.launch

class UsersPresenter(
    private val view: UsersContract.View?,
    private val getUsers: GetUsersContract,
    private val userDomainMapper: UserDomainMapper
) : UsersContract.Presenter<UsersContract.View>() {

    override fun getUsers() {
        launch {
            onSuccess(getUsers.execute(GetUsersContract.Param()))
        }
    }

    override fun onError(error: Throwable) {
        view?.showError("Something went wrong")
        Logs.error("Error: " + error.message)
    }

    private fun onSuccess(usersDomain: List<UserDomain>) {
        view?.showUsers(userDomainMapper.map(usersDomain))
    }
}
