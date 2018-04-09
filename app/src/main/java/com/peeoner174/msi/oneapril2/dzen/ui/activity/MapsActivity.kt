package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.peeoner174.msi.oneapril2.R
import kotlinx.android.synthetic.main.fragment_maps.*
import net.sharewire.googlemapsclustering.ClusterManager
import com.peeoner174.msi.oneapril2.dzen.util.SampleClusterItem
import net.sharewire.googlemapsclustering.Cluster

//Карта, на которой пользователь в дальнейшем сможет ставить отметки(в разработке)

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_maps)

        navigation3.selectedItemId = R.id.navigation_home
        navigation3.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        //https://android-arsenal.com/details/1/6552
        val clusterManager = ClusterManager<SampleClusterItem>(this, googleMap)
        googleMap.setOnCameraIdleListener(clusterManager)

        clusterManager.setCallbacks(object : ClusterManager.Callbacks<SampleClusterItem> {
            override fun onClusterClick(cluster: Cluster<SampleClusterItem>): Boolean {
                return false
            }

            override fun onClusterItemClick(clusterItem: SampleClusterItem): Boolean {
                return false
            }
        })

        val markers: ArrayList<LatLng> = arrayListOf(LatLng(-34.0, 151.0), LatLng(-35.0, 151.0), LatLng(-35.0, 150.0), LatLng(-34.0, 150.0), LatLng(-34.0, 149.0),
                LatLng(64.99193109437138,59.454947747290134), LatLng(65.22640106220652,60.28989862650633), LatLng(65.10942450500922,59.826037064194686),
                LatLng(44.64280321854763,33.70858870446681), LatLng(45.280819442519366,33.17583795636892), LatLng(44.982112733115194,34.734916873276234),
                LatLng(45.36351579983977,34.05330955982208), LatLng(35.852368112768055,14.406648874282835), LatLng(35.861567436272914,14.497377276420593),
                LatLng(35.833828181894326,14.470074735581875), LatLng(42.90978745372841,-76.0518254712224), LatLng(42.947427476390686,-75.99018763750792),
                LatLng(42.87792008802977,-76.03918187320232), LatLng(42.89414542470541,-76.16008713841438), LatLng(-18.025628854453714,-40.283082984387875),
                LatLng(-14.725992678546435,-40.13786047697067), LatLng(-19.949558722324376,-39.21811994165182), LatLng(-45.98448131574738,170.27294352650642),
                LatLng(-43.130079006023024,172.96211555600166), LatLng(-45.94290754374803,168.36064249277115), LatLng (-44.510851859212636,172.00596436858177)
        )

        googleMap.setOnCameraIdleListener(clusterManager)

        val clusterItems: MutableList<SampleClusterItem> = mutableListOf()
        for (i in 0 until markers.size) {
            clusterItems.add(SampleClusterItem(markers[i]))
        }
        clusterManager.setItems(clusterItems)
        clusterManager.setItems(clusterItems)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                return@OnNavigationItemSelectedListener true

            }

            R.id.navigation_dashboard -> {
                val intent = Intent(this, TapleActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }

            R.id.navigation_notifications -> {

                val intent = Intent(this, UserInfoActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
        false
    }

}
