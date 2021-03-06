package com.eugene_dolgushev

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.eugene_dolgushev.di.ApplicationDICompanion

class MainApp : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        ApplicationDICompanion.init()
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }
}