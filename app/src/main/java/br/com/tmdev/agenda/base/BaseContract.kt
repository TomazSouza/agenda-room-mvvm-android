package br.com.tmdev.agenda.base

interface BaseContract {

    interface View {
        fun showProgress(show: Boolean)
    }

    interface Presenter<T> {
        fun attach(view: T)
        fun unsubscribe()
    }

}