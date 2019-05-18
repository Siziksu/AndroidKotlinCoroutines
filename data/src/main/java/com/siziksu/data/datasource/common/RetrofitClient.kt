package com.siziksu.data.datasource.common

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.siziksu.data.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG) {
                    val loggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
                    addInterceptor(loggingInterceptor)
                }
                readTimeout(15, TimeUnit.SECONDS)
            }.build()
    }

    fun getRetrofit(okHttpClient: OkHttpClient, endPoint: String): Retrofit {
        return Retrofit.Builder()
            .apply {
                baseUrl(endPoint)
                client(okHttpClient)
                addConverterFactory(GsonConverterFactory.create())
                addCallAdapterFactory(CoroutineCallAdapterFactory())
            }.build()
    }
}