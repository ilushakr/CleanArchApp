package com.example.data.impl.di

import com.example.api.Repository
import com.example.data.impl.RepositoryImpl
import org.koin.dsl.module

val someRepositoryModule = module {
    single<Repository> { RepositoryImpl(get()) }
}