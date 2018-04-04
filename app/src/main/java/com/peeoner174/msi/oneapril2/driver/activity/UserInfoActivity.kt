package com.peeoner174.msi.oneapril2.driver.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.driver.adapter.UserViewPagerAdapter
import com.peeoner174.msi.oneapril2.driver.view.SecondPageUserView
import com.peeoner174.msi.oneapril2.driver.view.FirstPageUserView
import com.peeoner174.msi.oneapril2.driver.adapter.RecViewTripAdapter
import com.peeoner174.msi.oneapril2.driver.producer.TripDataLoaderWeb
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import com.peeoner174.msi.oneapril2.driver.model.Trip
import kotlinx.android.synthetic.main.activity_main.*


class UserInfoActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                val intent = Intent(this, MapsActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }

            R.id.navigation_dashboard -> {
                val intent = Intent(this, TapleActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
                startActivity(intent)
            }

            R.id.navigation_notifications -> {

                return@OnNavigationItemSelectedListener true
            }

        }
        false
    }


    private var adapter = RecViewTripAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = TripDataLoaderWeb()

    private var viewPager: ViewPager? = null
    private var userViewPagerAdapter: UserViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        toolbar.setTitle(R.string.user_name)
//        toolbar.setTitleTextColor(Color.BLACK) //Не работает!
//
//        setSupportActionBar(toolbar)

        //BottomNavigationView
        navigation1.selectedItemId = R.id.navigation_notifications
        navigation1.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initRecyclerView(findViewById(R.id.rv_trips_list))

        viewPager = findViewById<View>(R.id.container) as ViewPager?
        viewPager!!.offscreenPageLimit = 1// PageView имеет две страницы

        setupViewPager()

    }

    override fun onResume() {
        super.onResume()
        //Выносим загрузку данных в отдельный поток
        launch(UI) {
            val job = dataLoader.loadTrip()
            showUsers(job.await())//Возврат в UI
        }

    }

    private fun showUsers(trips: List<Trip>) {
        adapter.updateData(trips)
    }


    private fun setupViewPager() {
        userViewPagerAdapter = UserViewPagerAdapter()
        userViewPagerAdapter!!.addView(FirstPageUserView(findViewById<View>(R.id.first_view_page_user), this))
        userViewPagerAdapter!!.addView(SecondPageUserView(findViewById<View>(R.id.second_view_page_user), this))
        viewPager!!.adapter = userViewPagerAdapter

    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

}