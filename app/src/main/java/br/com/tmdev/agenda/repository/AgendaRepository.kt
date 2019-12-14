package br.com.tmdev.agenda.repository

import android.content.Context
import androidx.lifecycle.LiveData
import br.com.tmdev.agenda.db.UserDao
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.db.UserRoomDatabase

open class AgendaRepository {

    private var mUserDao: UserDao? = null

    constructor(context: Context) : super() {
        val db = UserRoomDatabase.getDatabase(context)
        mUserDao = db?.getUserDao()
    }

    suspend fun insert(userEntity: UserEntity) {
        mUserDao?.insertUser(userEntity)
    }

    fun getAllUsers(): LiveData<List<UserEntity>>? {
        return mUserDao?.getAlphabetizedUsers()
    }

    fun getById(id: Int): UserEntity? {
        return mUserDao?.getUserById(id)
    }

}