package com.example.currencyexchange.data.api

import com.example.currencyexchange.model.cash.CashResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApi {

    @GET("daily_json.js")
    suspend fun getCash(): Response<CashResponse>
}