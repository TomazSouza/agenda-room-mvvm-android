package br.com.tmdev.agenda.ui.form

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.appcompat.widget.AppCompatButton
import br.com.tmdev.agenda.R
import br.com.tmdev.agenda.entities.User
import com.google.android.material.textfield.TextInputEditText

class FormHelper (itemView: FormActivity) : TextWatcher {

    private val mEditFieldNome: TextInputEditText = itemView.findViewById(R.id.edit_text_name_id)
    private val mEditFieldContato: TextInputEditText = itemView.findViewById(R.id.edit_field_contact_id)
    private val mEditFieldEmail: TextInputEditText = itemView.findViewById(R.id.edit_field_email_id)

    val mBtnSave: AppCompatButton = itemView.findViewById(R.id.btn_save_id)

    init {
        mEditFieldNome.addTextChangedListener(this)
        mEditFieldContato.addTextChangedListener(this)
        mEditFieldEmail.addTextChangedListener(this)

        if (fieldIsEmpty()) {
            mBtnSave.isEnabled = false
        }
    }

    fun fieldIsEmpty(): Boolean {

        if (TextUtils.isEmpty(mEditFieldNome.text.toString().trim())) {
            return true
        }

        if (TextUtils.isEmpty(mEditFieldEmail.text.toString().trim())) {
            return true
        }

        if (TextUtils.isEmpty(mEditFieldContato.text.toString().trim())) {
            return true
        }

        mBtnSave.isEnabled = true

        return false
    }

    fun getDadosPreenchido(): User {
        val user = User()
        user.name = mEditFieldNome.text.toString().trim()
        user.email = mEditFieldEmail.text.toString().trim()
        user.contact = mEditFieldContato.text.toString().trim()
        return user
    }

    override fun afterTextChanged(s: Editable?) {
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        if (fieldIsEmpty()) {
            mBtnSave.isEnabled = false
        }
    }

}