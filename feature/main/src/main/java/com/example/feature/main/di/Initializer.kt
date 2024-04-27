package com.example.feature.main.di

import android.content.Context
import com.example.base.initializator.AbstractModuleInitializer
import org.koin.core.Koin
import org.koin.core.module.Module

class Initializer : AbstractModuleInitializer() {
    override fun create(context: Context, koin: Koin, modules: (List<Module>) -> Unit) {
        modules(
            listOf(
                mainModule
            )
        )
    }
}