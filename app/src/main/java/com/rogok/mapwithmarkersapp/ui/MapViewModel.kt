package com.rogok.mapwithmarkersapp.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rogok.mapwithmarkersapp.data.RetrofitInstance
import com.rogok.mapwithmarkersapp.models.Place
import kotlinx.coroutines.launch

class MapViewModel : ViewModel() {

    val placesLiveData = MutableLiveData<List<Place>>()

    init {
        viewModelScope.launch {
            placesLiveData.value = RetrofitInstance.remoteData.getPlaces().places
        }
    }
}