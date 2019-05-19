package com.siziksu.ui.presenter

import com.siziksu.domain.usecase.user.GetUsers
import com.siziksu.domain.usecase.user.GetUsersContract
import com.siziksu.ui.BaseUnitTest
import com.siziksu.ui.mapper.UserDomainMapper
import com.siziksu.ui.mocks.UserDomainBuilder
import com.siziksu.ui.model.User
import com.siziksu.ui.view.users.UsersContract
import com.siziksu.ui.view.users.UsersFragment
import com.siziksu.ui.view.users.UsersPresenter
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import io.mockk.slot
import kotlinx.coroutines.Dispatchers
import org.junit.Before
import org.junit.Test

class UsersPresenterTest : BaseUnitTest() {

    private val userDomainList = UserDomainBuilder().getUserDomainList(USER_IDS)
    private val userDomainMapper = UserDomainMapper()

    private val getUsers: GetUsersContract = mockk<GetUsers>()
    private val view: UsersContract.View = mockk<UsersFragment>(relaxed = true)
    private lateinit var presenter: UsersContract.Presenter<UsersContract.View>

    @Before
    fun setUp() {
        presenter = UsersPresenter(view, getUsers, userDomainMapper)
        presenter.coroutineDispatcher = Dispatchers.Unconfined
    }

    @Test
    fun `MainPresenter getUser success`() {
        coEvery { getUsers.execute(any()) } returns userDomainList

        presenter.getUsers()

        val slot = slot<List<User>>()
        coVerify { view.showUsers(capture(slot)) }

        assert(slot.captured[INDEX_TO_CHECK_ID].id == userDomainList[INDEX_TO_CHECK_ID].id)
    }

    @Test
    fun `MainPresenter getUser error`() {
        coEvery { getUsers.execute(any()) } throws Exception()

        presenter.getUsers()

        val slot = slot<String>()
        coVerify { view.showError(capture(slot)) }

        assert(slot.captured == "Something went wrong")
    }

    companion object {

        private const val INDEX_TO_CHECK_ID = 2

        private val USER_IDS = listOf(1, 2, 3)
    }
}
