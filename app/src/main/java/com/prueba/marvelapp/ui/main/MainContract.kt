package com.prueba.marvelapp.ui.main

import com.prueba.marvelapp.api.Data
import com.prueba.marvelapp.base.BaseAppContract
import com.prueba.marvelapp.models.Character

interface MainContract {

    interface View: BaseAppContract.View {

        fun showRecycler()
        fun loadDataSuccess(items: Data)
    }

    interface Presenter: BaseAppContract.Presenter<View> {

        fun showCharacters()

    }
}