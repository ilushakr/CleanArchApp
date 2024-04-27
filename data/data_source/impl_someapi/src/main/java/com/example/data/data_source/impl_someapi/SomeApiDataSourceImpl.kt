package com.example.data.data_source.impl_someapi

import com.example.api.DataSource
import com.example.api.DataSourceEntity

internal class SomeApiDataSourceImpl(private val someApi: SomeApi) : DataSource {

    override suspend fun getSomeData(): DataSourceEntity {
        return someApi.getSomeData().map()
    }

    private fun SomeDataDto.map() = DataSourceEntity(id = id)
}