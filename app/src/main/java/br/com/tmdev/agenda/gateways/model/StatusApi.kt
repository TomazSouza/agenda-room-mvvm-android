package br.com.tmdev.agenda.gateways.model

class StatusApi {

    var status: String? = ""
    var error: Boolean? = false

    override fun toString(): String {
        return "StatusApi(status=$status, error=$error)"
    }

}