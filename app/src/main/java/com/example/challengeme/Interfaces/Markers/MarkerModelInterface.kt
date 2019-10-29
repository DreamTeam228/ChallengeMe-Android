package com.example.challengeme.Interfaces.Markers

import com.example.challengeme.Markers.MapMarker

interface MarkerModelInterface {
    fun getEducationMarkers() : List<MapMarker>
    fun getShopMarkers() : List <MapMarker>
    fun getRentMarkers() : List<MapMarker>

    fun setEducationMarkers()
    fun setShopMarkers()
    fun setRentMarkers()
    }