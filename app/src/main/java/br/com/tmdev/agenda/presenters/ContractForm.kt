package br.com.tmdev.agenda.presenters

import br.com.tmdev.agenda.entities.User

interface ContractForm {

    interface View : BaseContract.View {
        fun nextActivity()
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun addDataUser(user: User)
    }

}