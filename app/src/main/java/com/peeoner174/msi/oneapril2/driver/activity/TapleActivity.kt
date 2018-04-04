package com.peeoner174.msi.oneapril2.driver.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.peeoner174.msi.oneapril2.R
import kotlinx.android.synthetic.main.taple_activity.*
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.peeoner174.msi.oneapril2.driver.model.Trip
import kotlinx.coroutines.experimental.android.UI
import com.peeoner174.msi.oneapril2.driver.adapter.RecViewTripAdapter
import com.peeoner174.msi.oneapril2.driver.producer.TripDataLoaderWeb


import kotlinx.coroutines.experimental.launch
/**
 * Компонент для визуального взаимодействия с пользователем
 * отображает наши View на экране
 */
class TapleActivity : AppCompatActivity() {


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent(this, MapsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
            R.id.navigation_dashboard -> {
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                val intent = Intent(this, UserInfoActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }
        }
        false
    }

    private var adapter = RecViewTripAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = TripDataLoaderWeb()

    /**
     * Стартовый медот Activity
     * с него начинается жизненный цикл компоенента
     * https://developer.android.com/guide/components/activities/activity-lifecycle.html
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Устанавливаем Activity
        setContentView(R.layout.taple_activity)


        navigation2.selectedItemId = R.id.navigation_dashboard

        navigation2.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//        val db: AppDatabase = Room.databaseBuilder(applicationContext(),
//                AppDatabase::class, "database_name").build()

        initRecyclerView(findViewById(R.id.rv_trips_list))
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        //Выносим загрузку данных в отдельный поток
        launch(UI) {
            val job = dataLoader.loadTrip()
            showUsers(job.await())
        }
    }

    private fun showUsers(trips: List<Trip>) {
        adapter.updateData(trips)
    }
}

