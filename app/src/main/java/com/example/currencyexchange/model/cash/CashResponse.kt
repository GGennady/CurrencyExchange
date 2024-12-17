package com.example.currencyexchange.model.cash

data class CashResponse(
    val Date: String,
    val PreviousDate: String,
    val PreviousURL: String,
    val Timestamp: String,
    val Valute: Map<String, CashItem>
)
