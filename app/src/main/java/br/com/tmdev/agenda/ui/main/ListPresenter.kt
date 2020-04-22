package br.com.tmdev.agenda.ui.main

import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository

class ListPresenter : ContractList.Presenter {

    private var mViewImpl: ContractList.View? = null
    private var mParseUserList: MutableList<User> = mutableListOf()
    private var mAgendaRepository: AgendaRepository? = null

    var mDeletedItem: User? = null
    var mDeletedIndexInt: Int = 0

    constructor(viewImpl: ContractList.View?,
                agendaRepository: AgendaRepository
    ) {
        this.mViewImpl = viewImpl
        this.mAgendaRepository = agendaRepository
    }

    override fun attach(view: ContractList.View) {
        this.mViewImpl = view
    }

    override fun unsubscribe() {
    }

    override fun setListUsers(userList: List<UserEntity>?) {
        if (userList != null && userList.isNotEmpty()) {

            mParseUserList.clear()

            for (userEntity in userList) {

                val user = User()
                user.id = userEntity.id
                user.name = userEntity.name
                user.contact = userEntity.contact
                user.email = userEntity.email
                mParseUserList.add(user)
            }

            mViewImpl?.showRecycler(true)
            mViewImpl?.updatedList(mParseUserList)
        } else {
            mViewImpl?.showRecycler(false)
        }
    }

    override fun removeItem(adapterPosition: Int) {
        val name: String = mParseUserList[adapterPosition].name!!

        mDeletedItem = mParseUserList[adapterPosition]
        mDeletedIndexInt = adapterPosition

        mAgendaRepository?.deleteById(mDeletedItem?.id!!)

        mParseUserList.removeAt(adapterPosition)

        if (mParseUserList.size == 0) {
            mViewImpl?.showRecycler(false)
        }

        mViewImpl?.updateUiRemovedItem(name)
    }

    override fun restoreItem() {
        val userEntity = UserEntity()
        userEntity.id = 0
        userEntity.name = mDeletedItem?.name.toString()
        userEntity.contact = mDeletedItem?.contact.toString()
        userEntity.email = mDeletedItem?.email.toString()

        mAgendaRepository?.insert(userEntity)
    }

    override fun setPositionEdit(position: Int) {
        val user = mParseUserList[position]
        mViewImpl?.editData(user.id)
    }

}