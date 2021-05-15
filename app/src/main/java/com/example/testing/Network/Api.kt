package com.example.testing.Network

import com.example.testing.Model.contestItem
import retrofit2.http.GET

interface Api {

    @GET("/api/v1/all")
    suspend fun getContest(): List<contestItem>
}