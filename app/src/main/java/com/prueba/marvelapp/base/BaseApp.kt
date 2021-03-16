package com.prueba.marvelapp.base

import android.app.Application
import android.app.Dialog
import com.prueba.marvelapp.di.component.ApplicationComponent
import com.prueba.marvelapp.di.component.DaggerApplicationComponent
import com.prueba.marvelapp.di.module.ApplicationModule
import com.prueba.marvelapp.util.ext.createProgressDialog

class BaseApp : Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()
    }

    fun setup() {
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this)).build()
        component.inject(this)
    }

    fun getApplicationComponent(): ApplicationComponent {
        return component
    }

    companion object {
        lateinit var instance: BaseApp private set
    }

}