package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.MySingleton
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.ui.adapter.UserViewPagerAdapter
import com.peeoner174.msi.oneapril2.dzen.ui.view.SecondPageUserView
import com.peeoner174.msi.oneapril2.dzen.ui.view.FirstPageUserView
import com.peeoner174.msi.oneapril2.dzen.ui.adapter.RecViewTripAdapter
import com.peeoner174.msi.oneapril2.dzen.producer.TripDataLoaderWeb
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import com.peeoner174.msi.oneapril2.dzen.data.model.User
import com.peeoner174.msi.oneapril2.dzen.producer.UserInfoLoad
import kotlinx.android.synthetic.main.activity_main.*


/**Экран с информацией о пользователе**/
class UserInfoActivity : AppCompatActivity() {

    private var adapter = RecViewTripAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = TripDataLoaderWeb()
    private val dataLoaderUserInfo = UserInfoLoad()

    private var viewPager: ViewPager? = null
    private var userViewPagerAdapter: UserViewPagerAdapter? = null
    private var user_photo: ImageView? = null
    private val userId = MySingleton.getInstance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val simpleProgressBar = findViewById<ProgressBar>(R.id.simpleProgressBarUserActivity)
        val simpleProgressBarUser = findViewById<ProgressBar>(R.id.ProgressBarUserPhoto)

        user_photo = findViewById<View>(R.id.iv_image_user_photo) as ImageView?

        //BottomNavigationView
        navigation1.selectedItemId = R.id.navigation_notifications
        navigation1.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initRecyclerView(findViewById(R.id.rv_trips_list))

        viewPager = findViewById<View>(R.id.container) as ViewPager?
        viewPager!!.offscreenPageLimit = 1// PageView имеет две страницы

        //Выносим загрузку данных в отдельный поток
        launch(UI) {
            simpleProgressBar.visibility = View.VISIBLE
            simpleProgressBarUser.visibility = View.VISIBLE

            val userInfo = dataLoaderUserInfo.loadUser().await()
            val cashJob = dataLoader.loadTripFromCache(application as App).await()
            if (cashJob.isNotEmpty()){
                showUsers(cashJob, userInfo)

                simpleProgressBar.visibility = View.INVISIBLE
                simpleProgressBarUser.visibility = View.INVISIBLE

            } else {
                val webJob = dataLoader.loadTrip()
                showUsers(webJob.await(), userInfo)

                simpleProgressBar.visibility = View.INVISIBLE
                simpleProgressBarUser.visibility = View.INVISIBLE

            }
        }

        setViewPager()
    }

    private fun showUsers(trips: List<Trip>, users: List<User>) {
        val sortedTrips: MutableList<Trip> = mutableListOf()
        for (i in 0 until trips.size){
            if (trips[i].user_name == users[userId.myVariable].full_name)
                sortedTrips.add(trips[i])
        }

        adapter.updateData(sortedTrips)
        user_photo?.let {
            Glide
                    .with(this@UserInfoActivity)
                    .load(users[userId.myVariable].main_photo)
                    .transition(DrawableTransitionOptions.withCrossFade())//смузи появление картинки
                    .into(it)
        }
    }

    private fun setViewPager() {
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

}