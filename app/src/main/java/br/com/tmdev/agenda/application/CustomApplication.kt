package br.com.tmdev.agenda.application

import android.app.Application

open class CustomApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }

    override fun onLowMemory() {
        super.onLowMemory()
    }

    override fun onTerminate() {
        super.onTerminate()
    }

}