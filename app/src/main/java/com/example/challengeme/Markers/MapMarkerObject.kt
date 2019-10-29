package com.example.challengeme.Markers

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Interfaces.Markers.MapObservableInterface
import com.example.challengeme.Interfaces.Markers.MapObserverInterface

class MapMarkerObject() : MapMarkerObjectInterface,
    MapObservableInterface {
    lateinit private var educationMarkers: List<MapMarker>
    lateinit private var shopMarkers: List<MapMarker>
    lateinit private var rentMarkers: List<MapMarker>
    lateinit private var observers : ArrayList<MapObserverInterface>

    override fun setEducationMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShopMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRentMarkers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getEducationMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShopMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getRentMarkers(): List<MapMarker> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun notifyObservers() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun registerObserver(o: MapObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteObserver(o: MapObserverInterface) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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