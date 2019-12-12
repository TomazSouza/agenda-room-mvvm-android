package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.databinding.ActivityFormBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.presenters.ContractForm
import br.com.tmdev.agenda.presenters.FormPresenter

open class FormActivity : AppCompatActivity(), ContractForm.View {

    private var mFormBinding: ActivityFormBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFormBinding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        mFormBinding?.formPresenter = FormPresenter(this)
        mFormBinding?.user = User()

    }

    override fun nextActivity() {
        Toast.makeText(this, "Clicado", Toast.LENGTH_SHORT).show()
    }

    override fun showProgress(show: Boolean) {

    }

}
