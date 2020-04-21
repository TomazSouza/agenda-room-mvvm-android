package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.databinding.ActivityFormBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.repository.AgendaRepository
import br.com.tmdev.agenda.ui.base.BaseActivity
import br.com.tmdev.agenda.ui.main.ListUserActivity
import br.com.tmdev.agenda.util.OpenActivity

open class FormActivity : BaseActivity(), ContractForm.View {

    private var mFormBinding: ActivityFormBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mFormBinding = DataBindingUtil.setContentView(this, R.layout.activity_form)
        mFormBinding?.formPresenter = FormPresenter(this, AgendaRepository(this))


        mFormBinding?.user = User()
        mFormBinding?.formPresenter?.attach(this)
        val mFormHelper = FormHelper(this)
        mFormBinding?.formPresenter?.editData(intent.extras)
    }

    override fun updateUi(user: User?) {
        mFormBinding?.user = user
    }

    override fun nextActivity() {
      onBackPressed()
    }

    override fun onBackPressed() {
        OpenActivity.start(this, ListUserActivity::class.java, true, null)
    }

    override fun showProgress(show: Boolean) {

    }

}
