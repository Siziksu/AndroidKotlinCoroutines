package com.siziksu.ui.view.users

import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUsersContract
import com.siziksu.ui.common.utils.Logs
import com.siziksu.ui.mapper.UserDomainMapper
import kotlinx.coroutines.launch

class UsersViewModel(
    private val getUsers: GetUsersContract,
    private val userDomainMapper: UserDomainMapper
) : UsersViewModelContract() {

    override fun getUsers() {
        launch {
            showProgress()
            onSuccess(getUsers.execute(GetUsersContract.Param()))
        }
    }

    override fun onError(error: Throwable) {
        errorLiveData.value = "Something went wrong"
        Logs.error("Error: " + error.message)
        hideProgress()
    }

    override fun showProgress() {
        progressLiveData.value = true
    }

    override fun hideProgress() {
        progressLiveData.value = false
    }

    private fun onSuccess(userDomainList: List<UserDomain>) {
        usersLiveData.value = userDomainMapper.map(userDomainList)
        hideProgress()
    }
}
