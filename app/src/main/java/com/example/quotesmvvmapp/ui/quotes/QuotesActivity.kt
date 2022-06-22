package com.example.quotesmvvmapp.ui.quotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.quotesmvvmapp.R
import com.example.quotesmvvmapp.data.Quote
import com.example.quotesmvvmapp.utils.Injector

class QuotesActivity : AppCompatActivity() {

    lateinit var quotesTv: TextView
    lateinit var quoteEt: EditText
    lateinit var authorEt: EditText
    lateinit var addBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quotes)

        quotesTv = findViewById(R.id.tv_quotes)
        quoteEt = findViewById(R.id.et_quote)
        authorEt = findViewById(R.id.et_author)
        addBtn = findViewById(R.id.btn_add_quote)

        initUI()
    }

    private fun initUI(){
        val factory = Injector.provideQuotesViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach{quote -> stringBuilder.append("\t$quote\n\n")}
            quotesTv.text = stringBuilder.toString()
        })

        addBtn.setOnClickListener{
            val quote = Quote(quoteEt.text.toString(), authorEt.text.toString())

            viewModel.addQuote(quote)
            quoteEt.setText("")
            authorEt.setText("")
        }
    }
}