package br.com.tmdev.agenda.presenters

import android.text.TextUtils
import android.util.Log
import br.com.tmdev.agenda.entities.User

open class FormPresenter : ContractForm.Presenter {

    private var mViewImpl: ContractForm.View? = null

    constructor(viewImpl: ContractForm.View) : super() {
        this.mViewImpl = viewImpl
    }

    override fun addDataUser(user: User) {

        if (TextUtils.isEmpty(user.email) ||
            TextUtils.isEmpty(user.name) ||
            TextUtils.isEmpty(user.contact)) {

            Log.w("script", "isEmpty")
        } else{
            Log.w("script", "preenchido: ${user}")
            mViewImpl?.nextActivity()
        }
    }

    override fun attach(view: ContractForm.View) {
        this.mViewImpl = view
    }

    override fun unsubscribe() {

    }

}