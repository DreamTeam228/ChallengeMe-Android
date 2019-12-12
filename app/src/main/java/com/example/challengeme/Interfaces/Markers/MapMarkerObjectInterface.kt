package com.example.challengeme.Interfaces.Markers

import android.os.Parcelable
import com.example.challengeme.Markers.MapMarker

interface MapMarkerObjectInterface : Parcelable {
    fun getEducationMarkers() : ArrayList<MapMarker>
    fun getShopMarkers() : ArrayList <MapMarker>
    fun getRentMarkers() : ArrayList<MapMarker>

    fun setEducationMarkers(m: ArrayList<MapMarker>)
    fun setShopMarkers(m: ArrayList<MapMarker>)
    fun setRentMarkers(m: ArrayList<MapMarker>)

    fun addMarker(m:MapMarker)
    fun addEducationMarker(m: MapMarker)
    fun addRentMarker(m: MapMarker)
    fun addShopMarker(m: MapMarker)
    }