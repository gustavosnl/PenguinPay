package com.glima.penguinpay.remittance

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.glima.penguinpay.R
import com.glima.penguinpay.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: RemittanceViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.updateExchangeTable()
        setupViews()
        setupObservables()
    }

    private fun setupViews() {
        setupAmountInputEditText()
    }

    private fun setupObservables() {
        viewModel.convertedValue.observe(this) {
            binding.textViewConvertedAmount.text =
                resources.getString(R.string.text_exchanged_value, "KES", it)
        }
    }


    private fun setupAmountInputEditText() {
        binding.editTextTextAmount.apply {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.handleValueInput(text.toString(), "KES")
                }

                override fun afterTextChanged(p0: Editable?) {}
            })
        }
    }


}