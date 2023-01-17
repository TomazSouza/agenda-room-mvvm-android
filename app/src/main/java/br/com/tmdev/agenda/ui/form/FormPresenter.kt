package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import br.com.tmdev.agenda.constants.BundleConstants
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class FormPresenter(contractForm: ContractForm.View?, agendaRepository: AgendaRepository) : ContractForm.Presenter {

    private var mAgendaRepository: AgendaRepository? = agendaRepository
    private var mViewImp: ContractForm.View? = contractForm

    override fun addDataUser(user: User) {

        val userEntity = UserEntity()
        userEntity.id = user.id
        userEntity.name = user.name.toString()
        userEntity.contact = user.contact.toString()
        userEntity.email = user.email.toString()

        if (user.id != 0) {
            mAgendaRepository?.update(userEntity)
        } else {
            mAgendaRepository?.insert(userEntity)
        }

        this.mViewImp?.nextActivity()
    }

    @OptIn(DelicateCoroutinesApi::class)
    override fun editData(bundle: Bundle?) = GlobalScope.launch {
        if (bundle != null && bundle.containsKey(BundleConstants.KEY.ID_USER)) {

            val id =  bundle.getInt(BundleConstants.KEY.ID_USER)

            val userEntity = mAgendaRepository?.getById(id)

            val user = User()
            user.id = userEntity?.id!!
            user.name = userEntity.name
            user.contact = userEntity.contact
            user.email = userEntity.email

            mViewImp?.updateUi(user)
        }
    }

    override fun attach(view: ContractForm.View) {
        this.mViewImp = view
    }

    override fun unsubscribe() {
    }

}