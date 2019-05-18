package com.siziksu.data.di

import com.siziksu.data.repository.BackendRepository
import com.siziksu.domain.repository.BackendRepositoryContract
import org.koin.dsl.module.module

val repositoryModule = module {

    single<BackendRepositoryContract> {
        BackendRepository(get(), get())
    }
}
