package com.rogok.mapwithmarkersapp.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.rogok.mapwithmarkersapp.R
import com.rogok.mapwithmarkersapp.adapter.PlacesAdapter
import com.rogok.mapwithmarkersapp.databinding.FragmentMapBinding
import com.rogok.mapwithmarkersapp.models.Place

//AIzaSyAWvJEQXiRX45c4JXWxyjFDnHoi7JUXvRU

class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback {

    private lateinit var binding: FragmentMapBinding
    private val mapViewModel: MapViewModel by viewModels()
    private val args: MapFragmentArgs by navArgs()
    private lateinit var placesList: List<Place>
    private val placesAdapter by lazy {
        PlacesAdapter()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mapViewModel.placesLiveData.observe(viewLifecycleOwner, {
            placesAdapter.setData(it)
            placesList = it
            val mapFragment = childFragmentManager.findFragmentById(R.id.map) as? SupportMapFragment
            mapFragment?.getMapAsync(this)
        })
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapBinding.bind(view)
        (requireActivity() as AppCompatActivity).supportActionBar?.apply {
            (binding.toolbarMap)
            setDisplayShowTitleEnabled(false)
        }
        setupRecyclerView()
        binding.toolbarTitle.text = args.email
    }

    private fun setupRecyclerView() {
        binding.rvMapFrag.apply {
            adapter = placesAdapter
            layoutManager = LinearLayoutManager(binding.root.context)
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.apply {
            placesList.forEach {
                addMarker(
                    MarkerOptions()
                        .position(LatLng(it.lat, it.lng))
                        .title(it.name)
                )
            }
        }
    }
}
