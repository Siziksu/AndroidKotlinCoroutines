package com.siziksu.data.datasource.backend

import com.siziksu.data.model.UserData
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface BackendApi {

    @GET("users")
    fun getUsersAsync(): Deferred<List<UserData>>

    @GET("users/{userId}")
    fun getUserAsync(@Path("userId") id: Int): Deferred<UserData>
}
