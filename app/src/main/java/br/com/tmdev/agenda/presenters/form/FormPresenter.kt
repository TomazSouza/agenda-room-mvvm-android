package br.com.tmdev.agenda.presenters.form

import br.com.tmdev.agenda.entities.User

class FormPresenter : ContractForm.Presenter {

    private var mContractForm: ContractForm? = null

    constructor(mContractForm: ContractForm?) : super() {
        this.mContractForm = mContractForm
    }

    override fun addDataUser(user: User) {

    }

    override fun attach(view: ContractForm.View) {

    }

    override fun unsubscribe() {

    }

}