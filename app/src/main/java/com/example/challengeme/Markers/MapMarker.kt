package com.example.challengeme.Markers

import android.os.Parcel
import android.os.Parcelable
import com.google.android.gms.maps.model.LatLng

class MapMarker(val lat:Double,val lng:Double, val name:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString()!!
    )

    // создает объект-метку для карты
    fun toLatLang():LatLng {
        return LatLng(lat,lng)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(lat)
        parcel.writeDouble(lng)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MapMarker> {
        override fun createFromParcel(parcel: Parcel): MapMarker {
            return MapMarker(parcel)
        }

        override fun newArray(size: Int): Array<MapMarker?> {
            return arrayOfNulls(size)
        }
    }



}

