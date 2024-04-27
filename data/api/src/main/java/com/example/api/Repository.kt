package com.example.api

import com.example.entities.SomeDataEntity

interface Repository {

    suspend fun getSomeData(): SomeDataEntity
}