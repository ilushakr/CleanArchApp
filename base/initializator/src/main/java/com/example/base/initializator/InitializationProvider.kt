package com.example.base.initializator

import android.content.ComponentName
import android.content.ContentProvider
import android.content.ContentValues
import android.content.Context
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import java.lang.IllegalStateException

class InitializationProvider : ContentProvider() {

    private val valueInitialization by lazy {
        context!!.getString(R.string.value_initialization)
    }

    private val valueStartModules by lazy {
        context!!.getString(R.string.value_start_modules)
    }

    private val valueStartApp by lazy {
        context!!.getString(R.string.value_startapp)
    }

    override fun onCreate(): Boolean {
        initApp(context!!)
        return true
    }

    private fun initApp(context: Context) {

        val initializersMap = getInitializersMap(context)

        startKoin {
            androidLogger()
            androidContext(context)

            initializersMap[valueInitialization]?.forEach {
                (it as? AbstractInitializer)?.create(context) { moduleList ->
                    modules(moduleList)
                }
            }


            initializersMap[valueStartModules]?.forEach {
                (it as? AbstractModuleInitializer)?.create(context, koin) { moduleList ->
                    modules(moduleList)
                }
            }

            initializersMap[valueStartApp]?.forEach {
                (it as? AbstractAppInitializer)?.create(context, koin) { moduleList ->
                    modules(moduleList)
                }
            }

        }.koin

    }

    private fun getInitializersMap(context: Context): Map<String, Set<Any>> {
        val provider = ComponentName(context.packageName, InitializationProvider::class.java.name)
        val providerInfo =
            context.packageManager.getProviderInfo(provider, PackageManager.GET_META_DATA)
        val metaData = providerInfo.metaData

        val map = buildMap {
            put(valueInitialization, mutableSetOf<AbstractInitializer>())
            put(valueStartModules, mutableSetOf<AbstractModuleInitializer>())
            put(valueStartApp, mutableSetOf<AbstractAppInitializer>())
        }

        fun <T> setClass(key: String, className: String) {
            (Class.forName(className) as? Class<out T>)?.let {
                val instance = it.getDeclaredConstructor().newInstance()
                (map[key] as? MutableSet<T>)?.add(instance)
            }
        }

        metaData.keySet().forEach { key ->
            val value = metaData.getString(key, null)
            when (value) {
                valueInitialization -> {
                    setClass<AbstractInitializer>(valueInitialization, key)
                }

                valueStartModules -> {
                    setClass<AbstractModuleInitializer>(valueStartModules, key)
                }

                valueStartApp -> {
                    setClass<AbstractAppInitializer>(valueStartApp, key)
                }
            }
        }

        return map
    }

    override fun query(
        p0: Uri,
        p1: Array<out String>?,
        p2: String?,
        p3: Array<out String>?,
        p4: String?
    ): Cursor? {
        throw IllegalStateException(METHOD_NOT_ALLOWED)
    }

    override fun getType(p0: Uri): String? {
        throw IllegalStateException(METHOD_NOT_ALLOWED)
    }

    override fun insert(p0: Uri, p1: ContentValues?): Uri? {
        throw IllegalStateException(METHOD_NOT_ALLOWED)
    }

    override fun delete(p0: Uri, p1: String?, p2: Array<out String>?): Int {
        throw IllegalStateException(METHOD_NOT_ALLOWED)
    }

    override fun update(p0: Uri, p1: ContentValues?, p2: String?, p3: Array<out String>?): Int {
        throw IllegalStateException(METHOD_NOT_ALLOWED)
    }

    companion object {
        private const val METHOD_NOT_ALLOWED = "METHOD_NOT_ALLOWED"
    }
}