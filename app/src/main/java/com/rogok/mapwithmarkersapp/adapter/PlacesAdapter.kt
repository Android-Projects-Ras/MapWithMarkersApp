package com.rogok.mapwithmarkersapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rogok.mapwithmarkersapp.R
import com.rogok.mapwithmarkersapp.databinding.ItemPlaceBinding
import com.rogok.mapwithmarkersapp.models.Place

class PlacesAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var placesListRV = emptyList<Place>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return PlaceViewHolder(
            ItemPlaceBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PlaceViewHolder).bind(placesListRV[position])
    }

    override fun getItemCount() = placesListRV.size

    inner class PlaceViewHolder(private val binding: ItemPlaceBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(place: Place) {
            val sequenceNumber = adapterPosition.plus(1).toString()
            binding.tvSequenceNumber.text = sequenceNumber
            binding.tvPlaceName.text = place.name
        }
    }

    fun setData(newList: List<Place>) {
        placesListRV = newList
        notifyDataSetChanged()
    }
}