package com.example.base.initializator

import android.content.Context
import org.koin.core.Koin
import org.koin.core.module.Module

abstract class AbstractModuleInitializer {

    abstract fun create(context: Context, koin: Koin, modules: (List<Module>) -> Unit)
}