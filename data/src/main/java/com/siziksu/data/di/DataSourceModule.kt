package com.siziksu.data.di

import com.siziksu.data.BuildConfig
import com.siziksu.data.datasource.backend.BackendApi
import com.siziksu.data.datasource.backend.BackendDataSource
import com.siziksu.data.datasource.backend.BackendDataSourceContract
import com.siziksu.data.datasource.common.RetrofitClient
import org.koin.dsl.module.module
import retrofit2.Retrofit

const val BASE_URL = BuildConfig.BASE_URL

val dataSourceModule = module {

    single {
        RetrofitClient().getOkHttpClient()
    }

    single {
        RetrofitClient().getRetrofit(get(), BASE_URL)
    }

    single {
        get<Retrofit>().create(BackendApi::class.java)
    }

    single<BackendDataSourceContract> {
        BackendDataSource(get())
    }
}
