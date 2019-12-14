package br.com.tmdev.agenda.presenters.form

import android.util.Log
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository

class FormPresenter : ContractForm.Presenter {

    private var mContractForm: ContractForm? = null
    private var mAgendaRepository: AgendaRepository? = null

    constructor(
        mContractForm: ContractForm?,
        agendaRepository: AgendaRepository
    ) : super() {
        this.mContractForm = mContractForm
        this.mAgendaRepository = agendaRepository
    }

    override fun addDataUser(user: User) {
        val userEntity = UserEntity()
        userEntity.name = user.name.toString()
        userEntity.contact = user.contact.toString()
        userEntity.email = user.email.toString()

       mAgendaRepository?.insert(userEntity)
    }

    override fun attach(view: ContractForm.View) {

    }

    override fun unsubscribe() {

    }

}