package com.example.data.impl

import com.example.api.DataSource
import com.example.api.DataSourceEntity
import com.example.api.Repository
import com.example.entities.SomeDataEntity

internal class RepositoryImpl(private val dataSource: DataSource) : Repository {

    override suspend fun getSomeData(): SomeDataEntity {
        return dataSource.getSomeData().map()
    }

    private fun DataSourceEntity.map() = SomeDataEntity(id = id)
}