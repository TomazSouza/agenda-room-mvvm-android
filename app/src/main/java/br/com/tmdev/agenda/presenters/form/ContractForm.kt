package br.com.tmdev.agenda.presenters.form

import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.base.BaseContract

interface ContractForm {

    interface View : BaseContract.View {
        fun nextActivity()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun addDataUser(user: User)
    }

}