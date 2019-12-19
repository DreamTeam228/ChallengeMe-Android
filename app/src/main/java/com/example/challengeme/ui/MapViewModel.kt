package com.example.challengeme.ui

import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.Markers.MapMarkerObject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengeme.data.globalData.mapMarkerModel

import java.util.*


class MapViewModel() : ViewModel() {

    private val mapMarkerObject: MapMarkerObject = mapMarkerModel.instance

    private val _currentMarkers = MutableLiveData<ArrayList<MapMarker>>().apply {
        value = mapMarkerObject.getEducationMarkers()
    }

    val currentMarkers: LiveData<ArrayList<MapMarker>> = _currentMarkers


    fun setEducation() {
        _currentMarkers.value  = mapMarkerObject.getEducationMarkers()

    }
    fun setShop() {
        _currentMarkers.value  = mapMarkerObject.getShopMarkers()

    }
    fun setRent() {
        _currentMarkers.value  = mapMarkerObject.getRentMarkers()

    }
}