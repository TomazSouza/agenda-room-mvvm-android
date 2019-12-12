package br.com.tmdev.agenda.viewmodel

import android.text.TextUtils
import android.util.Log
import androidx.databinding.ObservableField
import br.com.tmdev.agenda.entities.User

open class ViewModel {

    var email = ObservableField<String>()
    var contact = ObservableField<String>()
    var name = ObservableField<String>()
    var loadingState = ObservableField<String>()

    fun onAddUser(user: User) {

        val fieldEmail = user.email
        val fieldName = user.name
        val fieldContact = user.contact

        if (TextUtils.isEmpty(fieldEmail) || TextUtils.isEmpty(fieldName) || TextUtils.isEmpty(fieldContact)) {

        } else{
            Log.w("script", "preenchido: ${user}")
        }

    }

}