package com.rogok.mapwithmarkersapp.data

import com.rogok.mapwithmarkersapp.models.PlacesResponse
import retrofit2.http.GET

interface PlacesService {
    //https://2fjd9l3x1l.api.quickmocker.com/kyiv/places
    @GET("places")
    suspend fun getPlaces(): PlacesResponse
}