package com.example.data.data_source.impl_otherapi.di

import com.example.api.DataSource
import com.example.data.data_source.impl_otherapi.OtherApi
import com.example.data.data_source.impl_otherapi.OtherApiDataSourceImpl
import org.koin.dsl.module

val otherApiDataSourceModule = module {
    single<DataSource> { OtherApiDataSourceImpl(OtherApi()) }
}