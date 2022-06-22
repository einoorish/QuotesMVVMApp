package com.example.quotesmvvmapp.ui.quotes

import androidx.lifecycle.ViewModel
import com.example.quotesmvvmapp.data.Quote
import com.example.quotesmvvmapp.data.QuoteRepository

class QuotesViewModel(private val quoteRepo: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepo.getQuotes()

    fun addQuote(quote: Quote) = quoteRepo.addQuote(quote)

}

