package com.example.data.data_source.impl_someapi

import kotlinx.coroutines.delay

internal class SomeApi {
    suspend fun getSomeData(): SomeDataDto {
        delay(500)
        return SomeDataDto("Some Api Id")
    }
}