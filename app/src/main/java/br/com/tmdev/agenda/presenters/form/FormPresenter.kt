package br.com.tmdev.agenda.presenters.form

import android.util.Log
import br.com.tmdev.agenda.db.UserEntity
import br.com.tmdev.agenda.entities.User
import br.com.tmdev.agenda.gateways.AgendaService
import br.com.tmdev.agenda.gateways.RetrofitInit
import br.com.tmdev.agenda.gateways.model.Aluno
import br.com.tmdev.agenda.gateways.model.StatusApi
import br.com.tmdev.agenda.gateways.model.StatusResponse
import br.com.tmdev.agenda.repository.AgendaRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FormPresenter : ContractForm.Presenter {

    private var mContractForm: ContractForm? = null
    private var mAgendaRepository: AgendaRepository? = null
    private var mViewImp: ContractForm.View? = null

    constructor(
        mContractForm: ContractForm?,
        agendaRepository: AgendaRepository
    ) : super() {
        this.mContractForm = mContractForm
        this.mAgendaRepository = agendaRepository
    }

    override fun addDataUser(user: User) {
        val userEntity = UserEntity()
        userEntity.name = user.name.toString()
        userEntity.contact = user.contact.toString()
        userEntity.email = user.email.toString()


        val retrofit = RetrofitInit().getInstance()

        val result = retrofit.create(AgendaService::class.java)

        val aluno = Aluno()
        aluno.nome = user.name
        aluno.email = user.email
        aluno.telefone = user.contact
        aluno.endereco = "desconhecido"

        result.salvarNovoAluno(aluno)?.enqueue(object : Callback<StatusResponse> {
            override fun onFailure(call: Call<StatusResponse>, t: Throwable) {
                Log.w("", "result: ${t.message}")
            }

            override fun onResponse(call: Call<StatusResponse>, response: Response<StatusResponse>) {
                Log.w("", "result: ${response.body()}")
                mAgendaRepository?.insert(userEntity)
            }
        })

//        result.getStatusApi()?.enqueue(object : Callback<StatusApi> {
//            override fun onFailure(call: Call<StatusApi>, t: Throwable) {
//
//
//            }
//
//            override fun onResponse(call: Call<StatusApi>, response: Response<StatusApi>) {
//
//            }
//        })

        //this.mViewImp?.nextActivity()
    }

    override fun attach(view: ContractForm.View) {
        this.mViewImp = view
    }

    override fun unsubscribe() {

    }

}