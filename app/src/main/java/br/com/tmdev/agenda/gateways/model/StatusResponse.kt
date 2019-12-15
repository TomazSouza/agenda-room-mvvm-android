package br.com.tmdev.agenda.gateways.model

class StatusResponse {

    var msg: String? = ""
    var idAluno: Int = 0
    var error: Boolean? = false

    override fun toString(): String {
        return "StatusResponse(msg=$msg, idAluno=$idAluno, error=$error)"
    }

}