package com.example.testing.Network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private val retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(Url.url2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    val api:Api by lazy{
        retrofit.create(Api::class.java)
    }
}