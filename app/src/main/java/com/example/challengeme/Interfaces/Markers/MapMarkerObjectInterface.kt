package com.example.challengeme.Interfaces.Markers

import android.os.Parcelable
import com.example.challengeme.Markers.MapMarker

interface MapMarkerObjectInterface : Parcelable {
    fun getEducationMarkers() : ArrayList<MapMarker>
    fun getShopMarkers() : ArrayList <MapMarker>
    fun getRentMarkers() : ArrayList<MapMarker>

    fun setEducationMarkers(m: List<MapMarker>)
    fun setShopMarkers(m: List<MapMarker>)
    fun setRentMarkers(m: List<MapMarker>)

    fun addEducationMarker(m: MapMarker)
    fun addRentMarker(m: MapMarker)
    fun addShopMarker(m: MapMarker)
    }