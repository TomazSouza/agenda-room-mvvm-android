package br.com.tmdev.agenda.repository

import android.content.Context
import androidx.lifecycle.LiveData
import br.com.tmdev.agenda.db.UserDao
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.db.UserRoomDatabase
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

open class AgendaRepository(context: Context) {

    private var mUserDao: UserDao? = null

    init {
        val db = UserRoomDatabase.getInstance(context)
        mUserDao = db?.getUserDao()
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insert(userEntity: UserEntity) = GlobalScope.launch {
        mUserDao?.insertUser(userEntity)
    }

    fun getAllUsers(): LiveData<List<UserEntity>>? {
        return mUserDao?.getAlphabetizedUsers()
    }

    fun getById(id: Int): UserEntity? {
        return mUserDao?.getUserById(id)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun update(userEntity: UserEntity) = GlobalScope.launch {
        mUserDao?.updated(userEntity.id, userEntity.name, userEntity.email, userEntity.contact)
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun deleteById(id: Int) = GlobalScope.launch {
        mUserDao?.deleteById(id)
    }

}