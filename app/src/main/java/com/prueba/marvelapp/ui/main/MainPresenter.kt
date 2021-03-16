package com.prueba.marvelapp.ui.main

import android.util.Log
import com.prueba.marvelapp.api.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*

class MainPresenter: MainContract.Presenter {

    private val subscriptions = CompositeDisposable()
    private lateinit var view: MainContract.View
    private val api: ApiService = ApiService.create()
    private val TAG = "MAIN"

    override fun showCharacters() {

        view.showProgressDialog()

        val subscribe = api.listCharacters()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({

                if (it != null) {
                    Log.e(TAG, "DATAAAA------${it}")
                    it.data.results.sort()
                    view.loadDataSuccess(it.data)
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

    override fun attach(view: MainContract.View) {
        this.view = view
    }
}