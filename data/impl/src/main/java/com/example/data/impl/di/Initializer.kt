package com.example.data.impl.di

import android.content.Context
import com.example.base.initializator.AbstractModuleInitializer
import org.koin.core.Koin
import org.koin.core.module.Module

class Initializer : AbstractModuleInitializer() {
    override fun create(context: Context, koin: Koin, modules: (List<Module>) -> Unit) {
        modules(
            listOf(
                someRepositoryModule
            )
        )
    }
}