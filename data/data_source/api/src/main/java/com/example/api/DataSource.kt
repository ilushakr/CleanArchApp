package com.example.api

interface DataSource {

    suspend fun getSomeData(): DataSourceEntity
}