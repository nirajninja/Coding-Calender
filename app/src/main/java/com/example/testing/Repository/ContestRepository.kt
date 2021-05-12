package com.example.testing.Repository

import com.example.testing.Model.contestItem
import com.example.testing.Network.RetrofitBuilder

class ContestRepository {
    suspend fun getContest():List<contestItem> = RetrofitBuilder.api.getContest()

}