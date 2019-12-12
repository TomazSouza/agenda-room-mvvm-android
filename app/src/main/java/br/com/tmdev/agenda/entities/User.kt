package br.com.tmdev.agenda.entities

import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR

open class User : BaseObservable() {

    @get:Bindable
    var name: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }

    @get:Bindable
    var email: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.email)
        }

    @get:Bindable
    var contact: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.contact)
        }

    override fun toString(): String {
        return "User(name=$name, email=$email, contact=$contact)"
    }

}