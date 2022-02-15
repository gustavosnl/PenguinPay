package com.glima.data.mapper

interface Mapper<T,R>  {
    fun mapFrom(response: T) : R
}