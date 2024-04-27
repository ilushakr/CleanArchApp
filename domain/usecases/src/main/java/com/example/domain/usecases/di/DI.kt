package com.example.domain.usecases.di

import com.example.domain.usecases.UseCase
import com.example.domain.usecases.UseCaseImpl
import org.koin.dsl.module

val someUseCaseModule = module {
    single<UseCase> { UseCaseImpl(get()) }
}