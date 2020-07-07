package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.base.BaseContract
import kotlinx.coroutines.Job

interface ContractForm {

    interface View : BaseContract.View {
        fun nextActivity()
        fun updateUi(user: User?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun addDataUser(user: User)
        fun editData(bundle: Bundle?): Job
    }

}