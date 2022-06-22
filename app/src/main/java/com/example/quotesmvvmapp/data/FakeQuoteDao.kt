package com.example.quotesmvvmapp.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val fakeQuotesTable = mutableListOf<Quote>()
    private val quotes = MutableLiveData<List<Quote>>() // can be observed from other classes

    init {
        quotes.value = fakeQuotesTable
    }

    fun addQuote(quote: Quote){
        fakeQuotesTable.add(quote)
        quotes.value = fakeQuotesTable // updating value triggers observers
    }

    fun getQuotes() = quotes as LiveData<List<Quote>>
}