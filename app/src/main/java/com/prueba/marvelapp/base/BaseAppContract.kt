package com.prueba.marvelapp.base

interface BaseAppContract {

    interface Presenter<T> {
        fun subscribe()
        fun unsubscribe()
        fun attach(view: T)
    }

    interface View {
        fun showProgressDialog()
        fun dismissProgressDialog()

    }
}