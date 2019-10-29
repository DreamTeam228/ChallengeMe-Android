package com.example.challengeme.Interfaces.Markers

import android.os.Parcelable
import com.example.challengeme.Markers.MapMarker

interface MapMarkerObjectInterface : Parcelable {
    fun getEducationMarkers() : List<MapMarker>
    fun getShopMarkers() : List <MapMarker>
    fun getRentMarkers() : List<MapMarker>

    fun setEducationMarkers()
    fun setShopMarkers()
    fun setRentMarkers()
    }