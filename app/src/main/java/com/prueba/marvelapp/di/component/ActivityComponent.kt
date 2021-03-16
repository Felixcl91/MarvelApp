package com.prueba.marvelapp.di.component

import com.prueba.marvelapp.ui.main.MainActivity
import com.prueba.marvelapp.di.module.ActivityModule
import com.prueba.marvelapp.ui.character.CharacterActivity
import dagger.Component

@Component(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(characterActivity: CharacterActivity)
}