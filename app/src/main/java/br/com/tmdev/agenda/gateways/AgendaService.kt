package br.com.tmdev.agenda.gateways

import br.com.tmdev.agenda.gateways.model.Aluno
import br.com.tmdev.agenda.gateways.model.QueryAlunos
import br.com.tmdev.agenda.gateways.model.StatusApi
import br.com.tmdev.agenda.gateways.model.StatusResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AgendaService {

    @GET("/status")
    fun getStatusApi(): Call<StatusApi>?

    @POST("/salvar")
    fun salvarNovoAluno(@Body aluno: Aluno): Call<StatusResponse>?

    @GET("/alunos")
    fun buscarTodos(): Call<QueryAlunos>?

}