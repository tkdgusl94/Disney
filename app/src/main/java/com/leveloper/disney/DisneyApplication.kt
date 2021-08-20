package com.leveloper.disney

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class DisneyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Fresco.initialize(applicationContext)
    }
}