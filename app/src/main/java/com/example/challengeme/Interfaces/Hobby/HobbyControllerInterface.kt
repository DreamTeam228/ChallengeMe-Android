package com.example.challengeme.Interfaces.Hobby

import android.app.Activity
import android.content.Context
import android.os.Parcelable
import androidx.appcompat.app.AppCompatActivity
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface

interface HobbyControllerInterface {
    fun onMapButtonClick(context: Context, obj: MapMarkerObjectInterface)
    fun onCompanyButtonClick()
    fun onProfileButtonClick()
    //fun startNewActivity(from : Context, to : Activity)
}