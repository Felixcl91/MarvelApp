package com.prueba.marvelapp.di.module

import android.app.Application
import com.prueba.marvelapp.base.BaseApp
import com.prueba.marvelapp.di.scope.PerApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(private val baseApp: BaseApp) {

    @Provides
    @Singleton
    @PerApplication
    fun provideApplication(): Application {
        return baseApp
    }

}