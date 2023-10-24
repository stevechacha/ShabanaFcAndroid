package com.fcshabana.shabanafcandroid

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ShabanaApp: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}