package com.appsv.chatapp

import android.app.Application
import com.appsv.chatapp.data.di.dataModule
import com.appsv.chatapp.presentation.di.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ChatApplication () : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                dataModule,presentationModule
            )
            androidContext(this@ChatApplication)
        }
    }
}