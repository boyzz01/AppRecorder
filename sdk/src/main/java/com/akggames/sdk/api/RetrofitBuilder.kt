package com.akggames.sdk.api

import ApiService
import android.app.Application
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {


    private lateinit var application: Application
    private lateinit var BASE_URL: String

    fun init(application: Application){
        RetrofitBuilder.application =application
        BASE_URL = "https://staging-auth.troves.gg/v1/api"
    }

    private val gson : Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    private val httpClient : OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    private val retrofit : Retrofit by lazy {
        val clientBuilder: OkHttpClient.Builder = buildClient()
        Retrofit.Builder()
            .baseUrl("https://staging-auth.troves.gg/v1/api")
            .client(clientBuilder
                .connectTimeout(1 , TimeUnit.MINUTES)
                .writeTimeout(1 , TimeUnit.MINUTES)
                .readTimeout(1 , TimeUnit.MINUTES)
                .addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                        .build()
                    chain.proceed(newRequest)
                }
                .retryOnConnectionFailure(true)
                .build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun buildClient(): OkHttpClient.Builder {
        val clientBuilder = OkHttpClient.Builder()
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        clientBuilder.addInterceptor(loggingInterceptor)
            .connectTimeout(5 , TimeUnit.MINUTES)
        return clientBuilder
    }

    val apiService :  ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}