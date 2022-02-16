package com.glima.penguinpay.remittance

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.glima.penguinpay.R
import com.glima.penguinpay.databinding.ItemReceivingMktBinding

class MarketAdapter(activity: Activity) :
    ArrayAdapter<MarketVO>(activity, R.layout.item_receiving_mkt) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent);
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return createItemView(position, convertView, parent);
    }

    private fun createItemView(position: Int, recycledView: View?, parent: ViewGroup): View {
        val country = getItem(position)
        val view = ItemReceivingMktBinding.inflate(LayoutInflater.from(context))


        country?.let {
            view.flag.setImageResource(country.flagIcon)
            view.countryCode.text = country.countryCode
            view.countryName.text = country.name
        }
        return view.root
    }
}