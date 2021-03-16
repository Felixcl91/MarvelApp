package com.prueba.marvelapp.di.module

import android.app.Activity
import com.prueba.marvelapp.ui.character.CharacterContract
import com.prueba.marvelapp.ui.character.CharacterPresenter
import com.prueba.marvelapp.ui.main.MainContract
import com.prueba.marvelapp.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(private var activity: Activity) {

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providePresenter(): MainContract.Presenter {
        return MainPresenter()
    }

    @Provides
    fun provideCharacterPresenter(): CharacterContract.Presenter {
        return CharacterPresenter()
    }
}