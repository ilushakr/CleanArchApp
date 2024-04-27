package com.example.data.data_source.impl_someapi.di

import com.example.api.DataSource
import com.example.data.data_source.impl_someapi.SomeApiDataSourceImpl
import com.example.data.data_source.impl_someapi.SomeApi
import org.koin.dsl.module

val someApiDataSourceModule = module {
    single<DataSource> { SomeApiDataSourceImpl(SomeApi()) }
}