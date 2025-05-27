package com.example.jetpackcomposetutorial.di.manual

import android.app.Application

class ManualApplication : Application() {
    companion object{
        lateinit var manualAppModule: ManualAppModule
    }
    override fun onCreate() {
        super.onCreate()
        manualAppModule=ManualAppModuleImpl(this@ManualApplication)
    }
}