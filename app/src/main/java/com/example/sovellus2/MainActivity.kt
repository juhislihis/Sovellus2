package com.example.sovellus2

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import org.osmdroid.config.Configuration
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView
    private var userLocation: GeoPoint? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ladataan OSMdroidin asetukset
        Configuration.getInstance().load(this, getSharedPreferences("osmdroid", MODE_PRIVATE))

        // Asetetaan näkymä activity_main.xml:stä
        setContentView(R.layout.activity_main)

        // Haetaan MapView ja muut komponentit
        mapView = findViewById(R.id.mapView)
        val centerButton: Button = findViewById(R.id.centerButton)

        // Asetetaan kartan alkusijainti ja zoom-taso
        val startPoint = GeoPoint(60.1699, 24.9384) // Esim. Helsinki
        mapView.setMultiTouchControls(true)
        mapView.controller.setZoom(15.0)
        mapView.controller.setCenter(startPoint)

        // Käsitellään keskitä sijaintiin -napin toiminta
        centerButton.setOnClickListener {
            userLocation?.let { location ->
                mapView.controller.setCenter(location)
            }
        }

        // Kysytään sijaintilupaa
        requestLocationPermission()
    }

    // Sijaintiluvan pyytäminen
    private fun requestLocationPermission() {
        val permission = Manifest.permission.ACCESS_FINE_LOCATION
        if (ContextCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED) {
            initializeMap()
        } else {
            ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
        }
    }

    // Kartan alustaminen
    private fun initializeMap() {
        // TODO: Lisää sijainnin seuraaminen ja päivittäminen kartalle
    }
}
