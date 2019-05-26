package com.siziksu.ui.view.users

import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUsersContract
import com.siziksu.ui.App
import com.siziksu.ui.R
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
        errorLiveData.value = getApplication<App>().getString(R.string.error_something_went_wrong)
        Logs.error(String.format(getApplication<App>().getString(R.string.error_with_description), error.message))
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
