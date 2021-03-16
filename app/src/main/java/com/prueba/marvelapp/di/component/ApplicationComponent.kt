package com.prueba.marvelapp.di.component

import android.app.Application
import com.prueba.marvelapp.base.BaseApp
import com.prueba.marvelapp.di.module.ApplicationModule
import dagger.Component

@Component(modules = arrayOf(ApplicationModule::class))
interface ApplicationComponent {

    fun inject(application: BaseApp)
}