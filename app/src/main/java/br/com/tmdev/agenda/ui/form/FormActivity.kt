package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.databinding.ActivityFormBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.presenters.form.ContractForm
import br.com.tmdev.agenda.presenters.form.FormPresenter
import br.com.tmdev.agenda.repository.AgendaRepository

open class FormActivity : AppCompatActivity(), ContractForm {

    private var mFormBinding: ActivityFormBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFormBinding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        mFormBinding?.formPresenter = FormPresenter(this,  AgendaRepository(this))
        mFormBinding?.user = User()

//        val mAgendaRepository = AgendaRepository(this)
//
//        mAgendaRepository.getAllUsers()?.observe(this, Observer {
//            Log.w("script", "users: $it")
//        })

        val mFormHelper = FormHelper(this)

    }

}
