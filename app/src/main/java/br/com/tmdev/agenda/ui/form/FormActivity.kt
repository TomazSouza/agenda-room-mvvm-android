package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.databinding.ActivityFormBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.presenters.form.ContractForm
import br.com.tmdev.agenda.presenters.form.FormPresenter

open class FormActivity : AppCompatActivity(), ContractForm {

    private var mFormBinding: ActivityFormBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFormBinding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        mFormBinding?.formPresenter = FormPresenter(this)
        mFormBinding?.user = User()

        val mFormHelper = FormHelper(this)

    }

}
