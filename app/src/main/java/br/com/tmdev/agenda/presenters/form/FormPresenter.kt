package br.com.tmdev.agenda.presenters.form

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository

class FormPresenter : ContractForm.Presenter {

    private var mContractForm: ContractForm? = null
    private var mAgendaRepository: AgendaRepository? = null
    private var mViewImp: ContractForm.View? = null

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

       this.mAgendaRepository?.insert(userEntity)
        this.mViewImp?.nextActivity()
    }

    override fun attach(view: ContractForm.View) {
        this.mViewImp = view
    }

    override fun unsubscribe() {

    }

}