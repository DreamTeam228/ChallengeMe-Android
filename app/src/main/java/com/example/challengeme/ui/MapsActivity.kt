package com.example.challengeme.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.ui.AppBarConfiguration
import com.example.challengeme.Interfaces.Markers.MapMarkerObjectInterface
import com.example.challengeme.Markers.MapMarker
import com.example.challengeme.R

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var model : MapMarkerObjectInterface
    private lateinit var mapViewModel: MapViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps_with_bottom_menu)
        val navView: BottomNavigationView = findViewById(R.id.mapsNavView)

        //val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.menu_item_edu,
                R.id.menu_item_rent,
                R.id.menu_item_shop
            )
        )
        navView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_item_rent -> {
                    mapViewModel.setRent()
                    true
                }
                R.id.menu_item_edu -> {
                    mapViewModel.setEducation()
                    true
                }
                R.id.menu_item_shop -> {
                    mapViewModel.setShop()
                    true
                }
                else -> {
                    mapViewModel.setRent()
                    true
                }
            }

        }
        //setupActionBarWithNavController(navController, appBarConfiguration)
        //navView.setupWithNavController(navController)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map2) as SupportMapFragment
        mapFragment.getMapAsync(this)
        //this.model = intent.getParcelableExtra(R.string.mapIntent.toString())!!   // следует ли это делать через контроллер?
        //this.markers = model.getEducationMarkers()                        // Предлагаю по дефолту при запуске показывать места обучения

        mapViewModel =
            ViewModelProviders.of(this).get(MapViewModel::class.java)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val startPoint = LatLng(55.7,37.6)                                // здесь будет местополжение пользователя
        mMap.moveCamera(CameraUpdateFactory.newLatLng(startPoint))
        mapViewModel.currentMarkers.observe(this, Observer {
            val markers = it?: return@Observer
            changeMarkers(markers)
        })
        // Устанавливаем маркеры

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        //mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))

    }

    fun changeMarkers(markers: ArrayList<MapMarker>) {

        mMap.clear()
        if (markers.isNotEmpty()) {
            for (i in 0 until markers.size) {
                val marker = markers[i]
                mMap.addMarker(
                    MarkerOptions()
                        .position(marker.toLatLang())
                        .title(marker.name)
                )
            }

        }
    }

    override fun onStop() {
        super.onStop()
        mMap.clear()
    }

}
