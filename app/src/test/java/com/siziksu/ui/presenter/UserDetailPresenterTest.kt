package com.siziksu.ui.presenter

import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.ui.BaseUnitTest
import com.siziksu.ui.mapper.UserDomainMapper
import com.siziksu.ui.mocks.UserDomainBuilder
import com.siziksu.ui.model.User
import com.siziksu.ui.view.detail.UserDetailContract
import com.siziksu.ui.view.detail.UserDetailFragment
import com.siziksu.ui.view.detail.UserDetailPresenter
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Test

class UserDetailPresenterTest : BaseUnitTest() {

    private val userDomain = UserDomainBuilder().getUserDomain(id = USER_ID)
    private val userDomainMapper = UserDomainMapper()

    private val getUser: GetUserContract = mockk<GetUser>()
    private val view: UserDetailContract.View = mockk<UserDetailFragment>(relaxed = true)
    private lateinit var presenter: UserDetailContract.Presenter<UserDetailContract.View>

    @Before
    fun setUp() {
        presenter = UserDetailPresenter(view, getUser, userDomainMapper)
        presenter.coroutineDispatcher = Dispatchers.Unconfined
    }

    @Test
    fun `MainPresenter getUser success`() {
        coEvery { getUser.execute(any()) } returns userDomain

        presenter.getUser(USER_ID)

        val slot = slot<User>()
        coVerify { view.showUser(capture(slot)) }

        assert(slot.captured.id == USER_ID)
    }

    @Test
    fun `MainPresenter getUser error`() {
        coEvery { getUser.execute(any()) } throws Exception()

        presenter.getUser(USER_ID)

        val slot = slot<String>()
        coVerify { view.showError(capture(slot)) }

        assert(slot.captured == "Something went wrong")
    }

    companion object {

        private const val USER_ID = 1
    }
}
