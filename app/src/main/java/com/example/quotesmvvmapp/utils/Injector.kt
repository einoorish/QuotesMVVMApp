package com.example.quotesmvvmapp.utils

import com.example.quotesmvvmapp.data.FakeDatabase
import com.example.quotesmvvmapp.data.QuoteRepository
import com.example.quotesmvvmapp.ui.quotes.QuotesViewModelFactory

object Injector {
    fun provideQuotesViewModelFactory(): QuotesViewModelFactory{
        val database = FakeDatabase.getInstance()
        val repository = QuoteRepository.getInstance(database.quoteDao)
        return QuotesViewModelFactory(repository)
    }
}