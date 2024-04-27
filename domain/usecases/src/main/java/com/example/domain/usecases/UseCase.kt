package com.example.domain.usecases

import com.example.entities.SomeDataEntity

interface UseCase {
    suspend operator fun invoke(): SomeDataEntity
}