package br.com.tmdev.agenda.ui.main

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User

class ListPresenter : ContractList.Presenter {

    private var mViewImpl: ContractList.View? = null
    private var mParseUserList: MutableList<User> = mutableListOf()

    constructor(viewImpl: ContractList.View?) {
        this.mViewImpl = viewImpl
    }

    override fun attach(view: ContractList.View) {
        this.mViewImpl = view
    }

    override fun unsubscribe() {
    }

    override fun setListUsers(userList: List<UserEntity>?) {
        if (userList != null && userList.isNotEmpty()) {
            for (userEntity in userList) {

                val user = User()
                user.id = userEntity.id
                user.name = userEntity.name
                user.contact = userEntity.contact
                user.email = userEntity.email
                mParseUserList.add(user)
            }
            mViewImpl?.updateList(mParseUserList)
        } else {
            mViewImpl?.updateListEmpty()
        }
    }

    override fun setPositionEdit(position: Int) {
        val user = mParseUserList[position]
        mViewImpl?.editData(user.id)
    }

}