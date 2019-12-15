package br.com.tmdev.agenda.gateways.model

class Aluno {

    var idAluno: Int = 0
    var nome: String? = ""
    var email: String? = ""
    var endereco: String? = ""
    var telefone: String? = ""

    override fun toString(): String {
        return "Aluno(idAluno=$idAluno, nome=$nome, email=$email, endereco=$endereco, telefone=$telefone)"
    }

}