package com.example.testapp

import android.app.Application
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TestApp : Application() {

    private var instance: TestApp? = null

    fun get(): TestApp? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}