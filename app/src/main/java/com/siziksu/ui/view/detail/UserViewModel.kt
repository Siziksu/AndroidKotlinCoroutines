package com.siziksu.ui.view.detail

import com.siziksu.domain.common.CoroutineCaseContract
import com.siziksu.domain.model.UserDomain
import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.ui.App
import com.siziksu.ui.R
import com.siziksu.ui.common.utils.Logs
import com.siziksu.ui.mapper.UserDomainMapper
import kotlinx.coroutines.launch

class UserViewModel(
    private val getUser: CoroutineCaseContract<UserDomain, GetUser.Params>,
    private val userDomainMapper: UserDomainMapper
) : UserViewModelContract() {

    override fun getUser(userId: Int?) {
        launch {
            userId?.let {
                showProgress()
                getUser.run(::onSuccess, ::onError, GetUser.Params(userId))
            }
        }
    }

    override fun onError(error: Throwable) {
        errorLiveData.value = error.message
        Logs.error(String.format(getApplication<App>().getString(R.string.error_with_description), error.message))
        hideProgress()
    }

    override fun showProgress() {
        progressLiveData.value = true
    }

    override fun hideProgress() {
        progressLiveData.value = false
    }

    private fun onSuccess(userDomain: UserDomain) {
        userLiveData.value = userDomainMapper.map(userDomain)
        hideProgress()
    }
}
