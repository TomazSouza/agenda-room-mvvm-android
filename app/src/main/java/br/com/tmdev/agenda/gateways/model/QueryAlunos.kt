package br.com.tmdev.agenda.gateways.model

class QueryAlunos {

    var alunos: MutableList<Aluno>? = null
    var error: Boolean? = false

    override fun toString(): String {
        return "QueryAlunos(alunos=$alunos, error=$error)"
    }

}