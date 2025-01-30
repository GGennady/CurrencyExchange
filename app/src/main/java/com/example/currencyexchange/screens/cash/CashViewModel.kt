package com.example.currencyexchange.screens.cash

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.currencyexchange.data.repository.Repository
import com.example.currencyexchange.model.cash.CashItem
import com.example.currencyexchange.model.cash.CashResponse
import kotlinx.coroutines.launch
import retrofit2.Response

class CashViewModel: ViewModel() {

    private val repository = Repository()

    private val _cashList = MutableLiveData<List<CashItem>>()
    val cashList: LiveData<List<CashItem>> get() = _cashList

    //private val _cashError = MutableLiveData<String>()
    //val cashError: LiveData<String> get() = _cashError

    fun fetchCash() {
        viewModelScope.launch {
            try {
                val response = repository.getCash()
                Log.d("CashViewModel", "Response: $response")

                if (response.isSuccessful && response.body() != null) {
                    val selectedCharCodes = listOf("USD", "BYN", "CNY")

                    val filteredList = response.body()!!.Valute
                        .filter { it.key in selectedCharCodes }
                        .values
                        .toList()

                    //Log.d("Test", filteredList.toString())

                    /*val filteredList = listOf(
                        CashItem("AUD", 61.13, 61.25),
                        CashItem("CHF", 108.15, 108.14),
                        CashItem("JPY", 62.98, 63.17)
                    )*/

                    _cashList.postValue(filteredList)
                }


            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}