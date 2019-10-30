package com.example.challengeme.Hobby

import android.app.Application
import android.content.Context
import android.content.Intent
import android.os.Parcelable
import com.example.challengeme.Interfaces.Hobby.HobbyControllerInterface
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Markers.MapsActivity
import com.example.challengeme.R

//private val INTENT_TAG = "model"

class HobbyController(private val model: HobbyObjectInterface) : HobbyControllerInterface {

    /*override fun startNewActivity(from: Context, to: Activity) {
        val i = Intent(from, to::class.java)
        i.putExtra(INTENT_TAG, model)
        startActivity(from, i, null)
    }*/


    override fun onMapButtonClick(context: Context, obj: MapMarkerObjectInterface) {
       val intent = Intent(context, MapsActivity::class.java)
        intent.putExtra(R.string.mapIntent.toString(),obj)

    }

    override fun onCompanyButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProfileButtonClick() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}