package com.example.test.presentation.di

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp
import java.lang.ref.WeakReference

@HiltAndroidApp
class App : Application() {

    companion object{

        private var context_: WeakReference<Context>? = null

        fun getContext(): Context? { return context_?.get() }
    }

    override fun onCreate() {
        super.onCreate()
        context_ = WeakReference(this)
    }
}