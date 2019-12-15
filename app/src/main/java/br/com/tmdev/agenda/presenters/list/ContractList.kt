package br.com.tmdev.agenda.presenters.list

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.base.BaseContract

interface ContractList {

    interface View : BaseContract.View {
        fun updateListEmpty()
        fun updateList(userList: MutableList<User>?)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun userUpdateList()
        fun setListUsers(userList: List<UserEntity>?)
    }

}