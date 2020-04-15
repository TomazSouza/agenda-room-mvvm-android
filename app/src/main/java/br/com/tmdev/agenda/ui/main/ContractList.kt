package br.com.tmdev.agenda.ui.main

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.base.BaseContract

interface ContractList {

    interface View : BaseContract.View {
        fun updateListEmpty()
        fun updateList(userList: MutableList<User>?)
        fun editData(id: Int)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun setListUsers(userList: List<UserEntity>?)
        fun setPositionEdit(position: Int)
    }

}