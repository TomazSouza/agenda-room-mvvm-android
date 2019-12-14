package br.com.tmdev.agenda.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.repository.AgendaRepository
import kotlinx.coroutines.launch

open class ListViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: AgendaRepository?

    init {
        mRepository = AgendaRepository(application)
    }

    fun insertUser(userEntity: UserEntity) = viewModelScope.launch {
        mRepository?.insert(userEntity)
    }

    fun getAllUsers(): LiveData<List<UserEntity>>? {
        return mRepository?.getAllUsers()
    }

}