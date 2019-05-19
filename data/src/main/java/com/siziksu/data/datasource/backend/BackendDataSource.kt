package com.siziksu.data.datasource.backend

import com.siziksu.data.model.UserData

class BackendDataSource(private val api: BackendApi) : BackendDataSourceContract {

    override suspend fun getUsers(): List<UserData> = api.getUsersAsync().await()

    override suspend fun getUser(userId: Int): UserData = api.getUserAsync(userId).await()
}
