package com.eliseche.androidseed

import android.app.Application
import android.content.Context

/**
 * Application entry point. Handles initialization and setup of libs.
 */
class MainApplication : Application() {
    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MainApplication

        fun applicationContext(): Context {
            return instance.applicationContext
        }

        fun buildVersion(): String {
            return "Version ${BuildConfig.VERSION_NAME}"
        }
    }

    override fun onCreate() {
        super.onCreate()

        /**
         * Do some stuff, ex init Firebase, Analytics, Push
         */
        val firebase = "Init Firebase"
    }
}
