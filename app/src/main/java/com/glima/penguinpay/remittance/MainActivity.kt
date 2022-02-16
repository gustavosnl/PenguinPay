package com.glima.penguinpay.remittance

import android.os.Bundle
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.glima.penguinpay.R
import com.glima.penguinpay.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: RemittanceViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MarketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.updateExchangeTable()
        setupObservables()
    }

    override fun onResume() {
        super.onResume()
        setupViews()
    }

    private fun setupViews() {
        setupAvailableMarkets()
        setupAmountInputEditText()
    }

    private fun updateConvertedLabelVisibility() {
        val visibility =  if (getInputAmount().isNotEmpty()) View.VISIBLE else View.INVISIBLE
        binding.textViewConvertedAmountLabel.visibility = visibility
        binding.textViewConvertedAmountValue.visibility = visibility

    }

    private fun setupAvailableMarkets() {
        adapter = MarketAdapter(this)
        binding.spinner.adapter = adapter

        populateAdapter()
        setupOnItemSelect()
    }

    private fun setupOnItemSelect() {
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(view: AdapterView<*>?, p1: View?, pos: Int, p3: Long) {
                val market = (view?.getItemAtPosition(pos) as MarketVO)
                changeCurrency(market.currency)
                updatePhoneMask(market.digits)
                updateCountryCode(market.countryCode)
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
    }

    private fun updateCountryCode(countryCode: String) {
        binding.textViewCountryCode.text = countryCode

    }

    private fun updatePhoneMask(digits: Int) {
        binding.editTextPhone.apply {
            filters = arrayOf(InputFilter.LengthFilter(digits))
            text.clear()
        }
    }

    private fun changeCurrency(currency: String) {
        binding.textViewConvertedAmountLabel.text = getString(R.string.exchanged_amount_label,currency)
        viewModel.handleValueInput(
            getInputAmount(),
            currency
        )
    }

    private fun getInputAmount() = binding.editTextTextAmount.text.toString()

    private fun populateAdapter() {
        viewModel.receivingMarkets.observe(this) {
            adapter.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    private fun setupObservables() {
        viewModel.convertedValue.observe(this) {
            binding.textViewConvertedAmountValue.text =
                resources.getString(R.string.exchanged_amount_value, it)
        }
    }


    private fun setupAmountInputEditText() {
        binding.editTextTextAmount.apply {
            addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

                override fun onTextChanged(text: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    viewModel.handleValueInput(text.toString(), getSelectedCountry())
                    updateConvertedLabelVisibility()
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
        }
    }

    private fun getSelectedCountry() = (binding.spinner.selectedItem as MarketVO).currency

}



