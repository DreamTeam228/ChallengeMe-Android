package com.example.challengeme.Markers

import android.os.Parcel
import android.os.Parcelable
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Interfaces.Markers.MapObservableInterface
import com.example.challengeme.Interfaces.Markers.MapObserverInterface

class MapMarkerObject : MapMarkerObjectInterface,
    MapObservableInterface {

    private lateinit var educationMarkers: ArrayList<MapMarker>
    private lateinit var shopMarkers: ArrayList<MapMarker>
    private lateinit var rentMarkers: ArrayList<MapMarker>
    private lateinit var observers : ArrayList<MapObserverInterface>

    override fun setEducationMarkers(m: List<MapMarker>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setShopMarkers(m: List<MapMarker>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun setRentMarkers(m: List<MapMarker>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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

    override fun notifyObservers() {
        observers.forEachIndexed { _, element ->
            element.update()
        }
    }

    override fun registerObserver(o: MapObserverInterface) {
        observers.add(o)
    }

    override fun deleteObserver(o: MapObserverInterface) {
        observers.remove(o)
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