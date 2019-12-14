package br.com.tmdev.agenda.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.repository.AgendaRepository

open class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: AgendaRepository?

    init {
        mRepository = AgendaRepository(application)
    }

    fun getAllUsers(): LiveData<List<UserEntity>>? {
        return mRepository?.getAllUsers()
    }

}