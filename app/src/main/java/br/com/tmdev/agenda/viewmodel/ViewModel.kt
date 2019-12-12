package br.com.tmdev.agenda.viewmodel

import android.util.Log
import android.view.View
import br.com.tmdev.agenda.entities.User

open class ViewModel {
    public fun setDados(user: User) {
        Log.w("script", "${user.name}")
        Log.w("script", "${user.email}")
        Log.w("script", "${user.contact}")
    }
}