package com.prueba.marvelapp.ui.character

import com.prueba.marvelapp.base.BaseAppContract
import com.prueba.marvelapp.models.Character

interface CharacterContract {

    interface View: BaseAppContract.View {
        fun showData(character: Character)
    }

    interface Presenter: BaseAppContract.Presenter<View> {
        fun showCharacter(id: Int)
    }
}