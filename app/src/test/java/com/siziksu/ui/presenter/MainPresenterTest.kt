package com.siziksu.ui.presenter

import com.siziksu.domain.usecase.user.GetUser
import com.siziksu.domain.usecase.user.GetUserContract
import com.siziksu.ui.BaseUnitTest
import com.siziksu.ui.mocks.UserDomainBuilder
import com.siziksu.ui.view.main.MainContract
import com.siziksu.ui.view.main.MainFragment
import com.siziksu.ui.view.main.MainPresenter
import com.siziksu.ui.view.mapper.UserDomainMapper
import com.siziksu.ui.view.model.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class MainPresenterTest : BaseUnitTest() {

    private val userDomain = UserDomainBuilder().getUserDomain(id = USER_ID)
    private val userDomainMapper = UserDomainMapper()

    private val getUser: GetUserContract = mockk<GetUser>()
    private val view: MainContract.View = mockk<MainFragment>(relaxed = true)
    private lateinit var presenter: MainContract.Presenter<MainContract.View>

    @Before
    fun setUp() {
        presenter = MainPresenter(view, getUser, userDomainMapper)
        presenter.coroutineDispatcher = Dispatchers.Unconfined
    }

    @Test
    fun `MainPresenter getUser success`() = runBlocking {
        coEvery { getUser.execute(any()) } returns userDomain

        presenter.getUser()

        val slot = slot<User>()
        coVerify { view.showUser(capture(slot)) }

        assert(slot.captured.id == USER_ID)
    }

    @Test
    fun `MainPresenter getUser error`() = runBlocking {
        coEvery { getUser.execute(any()) } throws Exception()

        presenter.getUser()

        val slot = slot<String>()
        coVerify { view.showError(capture(slot)) }

        assert(slot.captured == "Something went wrong")
    }

    companion object {

        const val USER_ID = 1
    }
}
