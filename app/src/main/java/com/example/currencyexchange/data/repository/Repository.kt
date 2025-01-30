package com.example.currencyexchange.data.repository

import com.example.currencyexchange.data.api.RetrofitInstance
import com.example.currencyexchange.model.cash.CashResponse
import retrofit2.Response

class Repository {
    suspend fun getCash(): Response<CashResponse> {
        return RetrofitInstance.api.getCash()
    }
}