package com.siziksu.data.repository

import com.siziksu.data.BaseUnitTest
import com.siziksu.data.datasource.backend.BackendDataSourceContract
import com.siziksu.data.mapper.UserDataMapper
import com.siziksu.data.mocks.UserDataBuilder
import com.siziksu.domain.repository.BackendRepositoryContract
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class BackendRepositoryTest : BaseUnitTest() {

    private val userData = UserDataBuilder().getAlbumData(id = USER_ID)

    private val backendDataSource = mockk<BackendDataSourceContract>()
    private val userMapper = UserDataMapper()
    private lateinit var backendRepository: BackendRepositoryContract

    @Before
    fun setUp() {
        backendRepository = BackendRepository(backendDataSource, userMapper)
    }

    @Test
    fun `AlbumRepository getUser success`() {
        coEvery { backendDataSource.getUser(any()) } returns userData

        val response = runBlocking { backendRepository.getUser(USER_ID) }

        assert(response.id == USER_ID)
    }

    @Test
    fun `AlbumRepository getUser error`() {
        coEvery { backendDataSource.getUser(any()) } throws Exception("DataSource Exception")
        try {
            runBlocking { backendRepository.getUser(USER_ID) }
        } catch (e: Exception) {
            assert(e.message == "DataSource Exception")
        }
    }

    companion object {

        const val USER_ID = 1
    }
}