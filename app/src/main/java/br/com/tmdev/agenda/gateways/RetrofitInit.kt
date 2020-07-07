package br.com.tmdev.agenda.gateways

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

open class RetrofitInit {

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.11:8081")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}