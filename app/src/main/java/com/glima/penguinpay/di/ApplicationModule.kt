package com.glima.penguinpay.di

import android.os.Build
import com.glima.data.api.ExchangeRateAPI
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ApplicationModule {
    val module = module {
        single<Retrofit> {
            Retrofit.Builder()
                .baseUrl("https://openexchangerates.org/api/")
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(get())
                .build()
        }

        single {
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        }

        single {
            val interceptor = HttpLoggingInterceptor().apply {
                level = if (Build.TAGS.contains("DEBUG")) Level.BODY else Level.NONE
            }
            OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor { chain: Interceptor.Chain ->
                    val request = chain.request().newBuilder()
                        .build()
                    chain.proceed(request)
                }
                .build()
        }

        single<ExchangeRateAPI>
        {
            (get() as Retrofit).create(ExchangeRateAPI::class.java)
        }
    }
}