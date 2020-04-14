package br.com.tmdev.agenda.repository

import android.content.Context
import androidx.lifecycle.LiveData
import br.com.tmdev.agenda.db.UserDao
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.db.UserRoomDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class AgendaRepository(context: Context) {

    private var mUserDao: UserDao? = null

    init {
        val db = UserRoomDatabase.getInstance(context)
        mUserDao = db?.getUserDao()
    }

    fun insert(userEntity: UserEntity) = GlobalScope.launch {
        mUserDao?.insertUser(userEntity)
    }

    fun getAllUsers(): LiveData<List<UserEntity>>? {
        return mUserDao?.getAlphabetizedUsers()
    }

    fun getById(id: Int): UserEntity? {
        return mUserDao?.getUserById(id)
    }

}