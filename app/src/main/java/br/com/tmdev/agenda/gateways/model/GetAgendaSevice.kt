package br.com.tmdev.agenda.gateways.model

import br.com.tmdev.agenda.gateways.AgendaService
import br.com.tmdev.agenda.gateways.RetrofitInit
import retrofit2.Retrofit

class GetAgendaSevice {

    private var mRetrofitInit: Retrofit? = null

    private constructor() : super() {
        this.mRetrofitInit = RetrofitInit().getInstance()
    }

    companion object {
        @Volatile
        private var INSTANCE: GetAgendaSevice? = null

        fun getInstance(): GetAgendaSevice? {
            if (INSTANCE == null) {
                synchronized(GetAgendaSevice::class) {
                    INSTANCE = GetAgendaSevice()
                }
            }
            return INSTANCE
        }

    }

    fun getAgendaService(): AgendaService? {
        return mRetrofitInit?.create(AgendaService::class.java)
    }

}