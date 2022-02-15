package com.glima.domain.business.model

interface PhoneRule {
    fun getCountryCode(): String
    fun getDigitsCount(): Int
}