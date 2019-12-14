package br.com.tmdev.agenda.presenters.list

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User

class ListPresenter : ContractList.Presenter {

    private var mViewImpl: ContractList.View? = null

    constructor(viewImpl: ContractList.View?) {
        this.mViewImpl = viewImpl
    }


    override fun userUpdateList() {

    }

    override fun attach(view: ContractList.View) {
       this.mViewImpl = view
    }

    override fun unsubscribe() {

    }

    override fun setListUsers(userList: List<UserEntity>?) {
        if (userList != null && userList.isNotEmpty()) {

            val parseUserList: MutableList<User> = mutableListOf()

            for (userEntity in userList) {

                val user = User()
                user.id = userEntity.id
                user.name = userEntity.name
                user.contact = userEntity.contact
                user.email = userEntity.email
                parseUserList.add(user)
            }

            mViewImpl?.updateList(parseUserList)
        }
    }

}