package com.glima.penguinpay.remittance

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glima.domain.business.model.CurrencyExchangeTable
import com.glima.domain.business.usecase.ConvertFromBinary
import com.glima.domain.business.usecase.ConvertToBinary
import com.glima.domain.business.usecase.GetAvailableReceivingMarkets
import com.glima.domain.business.usecase.GetCurrentExchangeRate
import kotlinx.coroutines.launch

class RemittanceViewModel(
    private val convertFromBinary: ConvertFromBinary,
    private val convertToBinary: ConvertToBinary,
    private val getCurrentExchangeRate: GetCurrentExchangeRate,
    private val getAvailableReceivingMarkets: GetAvailableReceivingMarkets
) : ViewModel() {

    private lateinit var currencyExchangeTable: CurrencyExchangeTable

    private val _convertedValue = MutableLiveData<String>()
    val convertedValue: LiveData<String>
        get() = _convertedValue


    private val _receivingMarkets = MutableLiveData<List<MarketVO>>()
    val receivingMarkets: LiveData<List<MarketVO>>
        get() = _receivingMarkets

    init {
        updateExchangeTable()
        displayMarkets()
    }


    fun updateExchangeTable() {
        viewModelScope.launch {
            currencyExchangeTable = getCurrentExchangeRate()
        }
    }

    private fun makeExchangeConversion(amount: String, currencyID: String) {
        val decimalAmount = convertFromBinary(amount)
        val convertedAmount = decimalAmount.times(currencyExchangeTable.getExchangeRate(currencyID))
        _convertedValue.value = convertToBinary(convertedAmount)
    }

    fun handleValueInput(input: String, currencyID: String) {
        makeExchangeConversion(input, currencyID)
    }

    private fun displayMarkets() {
        _receivingMarkets.value = getAvailableReceivingMarkets().map {
            MarketFactory.make(it)
        }
    }
}