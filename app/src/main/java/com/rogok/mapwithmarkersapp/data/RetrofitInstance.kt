package com.rogok.mapwithmarkersapp.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://2fjd9l3x1l.api.quickmocker.com/kyiv/"

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val remoteData = retrofit.create(PlacesService::class.java)
}