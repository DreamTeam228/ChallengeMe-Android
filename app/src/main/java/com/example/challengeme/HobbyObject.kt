package com.example.challengeme

import android.os.Parcel
import android.os.Parcelable

class HobbyObject( val name: String,
                   val category: String,
                   val difficulty: Int,
                   val description:String,
                   val images: Array<String>,
                   val guide:String,
                   val guideVideo: Array<String>,
                   val exercise: Array<String>,
                   val exerciseImage:Array<String>)
    : Parcelable {
/*
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.createStringArray(),
        parcel.readString(),
        parcel.createStringArray(),
        parcel.createStringArray(),
        parcel.createStringArray()
    )
*/

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(category)
        parcel.writeInt(difficulty)
        parcel.writeString(description)
        parcel.writeStringArray(images)
        parcel.writeString(guide)
        parcel.writeStringArray(guideVideo)
        parcel.writeStringArray(exercise)
        parcel.writeStringArray(exerciseImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HobbyObject> {
        override fun createFromParcel(parcel: Parcel): HobbyObject {

            return HobbyObject(
                parcel.readString()!!,
                parcel.readString()!!,
                parcel.readInt(),
                parcel.readString()!!,
                parcel.createStringArray()!!,
                parcel.readString()!!,
                parcel.createStringArray()!!,
                parcel.createStringArray()!!,
                parcel.createStringArray()!!)
        }

        override fun newArray(size: Int): Array<HobbyObject?> {
            return arrayOfNulls(size)
        }
    }
}