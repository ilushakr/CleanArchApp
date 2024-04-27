package com.example.data.data_source.impl_otherapi

import com.example.api.DataSource
import com.example.api.DataSourceEntity

internal class OtherApiDataSourceImpl(private val otherApi: OtherApi) : DataSource {

    override suspend fun getSomeData(): DataSourceEntity {
        return otherApi.getOtherData().map()
    }

    private fun OtherDataDao.map() = DataSourceEntity(id = id)
}