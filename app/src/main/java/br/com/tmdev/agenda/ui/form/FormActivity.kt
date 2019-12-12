package br.com.tmdev.agenda.ui.form

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.databinding.ActivityFormBinding
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.viewmodel.ViewModel

open class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityFormBinding = DataBindingUtil.setContentView(this, R.layout.activity_form)

        binding.user = User()
        binding.form = ViewModel()
    }



}
