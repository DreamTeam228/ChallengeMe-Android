package com.example.challengeme.Markers

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface

class MapMarkerObject : MapMarkerObjectInterface {

    // Аналогично рпедлагаю рассмотреть синглтоны

    private var educationMarkers: ArrayList<MapMarker> = ArrayList()
    private var shopMarkers: ArrayList<MapMarker> = ArrayList()
    private var rentMarkers: ArrayList<MapMarker> = ArrayList()

    fun isDataRecieved() : Boolean {
        return (educationMarkers.isNotEmpty() && shopMarkers.isNotEmpty() && rentMarkers.isNotEmpty())
    }

    override fun setEducationMarkers(m: ArrayList<MapMarker>) {
       this.educationMarkers = m
    }

    override fun setShopMarkers(m: ArrayList<MapMarker>) {
        this.shopMarkers = m
            }

    override fun setRentMarkers(m: ArrayList<MapMarker>) {
        this.rentMarkers = m
    }

    override fun addMarker(m: MapMarker) {
        when (m.category) {
            "edu" -> addEducationMarker(m)
            "shop" -> addShopMarker(m)
            "rent" -> addRentMarker(m)
            "all" -> {
                addEducationMarker(m)
                addRentMarker(m)
                addShopMarker(m)
            }

        }
    }

    override fun addEducationMarker(m: MapMarker) {
        this.educationMarkers.add(m)
    }

    override fun addRentMarker(m: MapMarker) {
        this.rentMarkers.add(m)
       }

    override fun addShopMarker(m: MapMarker) {
        this.shopMarkers.add(m)
         }



    override fun getEducationMarkers(): ArrayList<MapMarker> {
        return this.educationMarkers
    }

    override fun getShopMarkers(): ArrayList<MapMarker> {
        return this.shopMarkers
    }

    override fun getRentMarkers(): ArrayList<MapMarker> {
        return this.rentMarkers
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(educationMarkers)
        parcel.writeTypedList(shopMarkers)
        parcel.writeTypedList(rentMarkers)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MapMarkerObject> {
        override fun createFromParcel(parcel: Parcel): MapMarkerObject {
            return MapMarkerObject()
        }

        override fun newArray(size: Int): Array<MapMarkerObject?> {
            return arrayOfNulls(size)
        }
    }

}