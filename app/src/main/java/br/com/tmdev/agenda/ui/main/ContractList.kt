package br.com.tmdev.agenda.ui.main

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.base.BaseContract

interface ContractList {

    interface View : BaseContract.View {
        fun showRecycler(show: Boolean)
        fun updatedList(userList: MutableList<User>?)
        fun editData(id: Int)
        fun updateUiRemovedItem(name: String)
    }

    interface Presenter : BaseContract.Presenter<View> {
        fun setListUsers(userList: List<UserEntity>?)
        fun setPositionEdit(position: Int)
        fun removeItem(adapterPosition: Int)
        fun restoreItem()

    }

}