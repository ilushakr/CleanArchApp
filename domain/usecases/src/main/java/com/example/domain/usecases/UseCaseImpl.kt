package com.example.domain.usecases

import com.example.api.Repository
import com.example.entities.SomeDataEntity

internal class UseCaseImpl(private val repository: Repository): UseCase {
    override suspend fun invoke(): SomeDataEntity {
        return repository.getSomeData()
    }
}