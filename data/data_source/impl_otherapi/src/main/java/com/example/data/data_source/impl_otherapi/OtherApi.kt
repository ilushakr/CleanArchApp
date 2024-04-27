package com.example.data.data_source.impl_otherapi

import kotlinx.coroutines.delay

internal class OtherApi {
    suspend fun getOtherData(): OtherDataDao {
        delay(500)
        return OtherDataDao("Other Api Id")
    }
}