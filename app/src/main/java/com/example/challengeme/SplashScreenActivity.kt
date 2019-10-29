package com.example.challengeme

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challengeme.Hobby.HobbyObject
import com.example.challengeme.Hobby.MainActivity
import com.example.challengeme.Interfaces.Hobby.HobbyObjectInterface
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Markers.MapMarkerObject


class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        var hobbyModel: HobbyObjectInterface = HobbyObject()
        var mapMarkersModel: MapMarkerObjectInterface = MapMarkerObject()

        //var hobbyController: HobbyControllerInterface = HobbyController(hobbyModel)

        val i = Intent(this, MainActivity::class.java)
        i.putExtra("hobbyModel", hobbyModel)
        i.putExtra("mapMarkersModel", mapMarkersModel)
        startActivity(i)
    }

}
