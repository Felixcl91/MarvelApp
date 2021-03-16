package com.prueba.marvelapp.ui.character

import android.util.Log
import com.prueba.marvelapp.api.ApiService
import com.prueba.marvelapp.ui.main.MainContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class CharacterPresenter: CharacterContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: CharacterContract.View
    private val api: ApiService = ApiService.create()
    private val TAG = "CHARACTER"

    override fun showCharacter(id: Int) {
        view.showProgressDialog()

        val subscribe = api.character(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.data.results.forEach { ch->
                    view.showData(ch)
                    view.dismissProgressDialog()
                }

            }, { error ->
                Log.e(TAG, error.localizedMessage)
            })
        subscriptions.add(subscribe)
    }

    override fun subscribe() {
    }

    override fun unsubscribe() {
        subscriptions.clear()
    }

    override fun attach(view: CharacterContract.View) {
        this.view = view
    }
}