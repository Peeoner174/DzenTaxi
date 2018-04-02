package com.peeoner174.msi.oneapril2.UserActivity

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View

import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.UserActivity.Adapter.ViewPagerAdapter
import com.peeoner174.msi.oneapril2.UserActivity.View.OnePageView
import com.peeoner174.msi.oneapril2.UserActivity.View.TwoPageView
import com.peeoner174.msi.oneapril2.driver.DriverAdapter
import com.peeoner174.msi.oneapril2.driver.DriverDataLoader
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import com.peeoner174.msi.oneapril2.driver.model.Driver



class UserInfoActivity : AppCompatActivity() {


    private var adapter = DriverAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = DriverDataLoader()


    private var viewPager: ViewPager? = null
    private var viewPagerAdapter: ViewPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView(findViewById(R.id.rv_drivers_list))


        viewPager = findViewById<View>(R.id.container) as ViewPager?
        viewPager!!.offscreenPageLimit = 1

        setupViewPager()

    }

    override fun onResume() {
        super.onResume()
        //Выносим загрузку данных в отдельный поток
        launch(UI) {
            val job = dataLoader.loadUsers()
            showUsers(job.await())
        }

    }

    private fun showUsers(drivers: List<Driver>) {
        adapter.updateData(drivers)
    }


    private fun setupViewPager() {
        viewPagerAdapter = ViewPagerAdapter()
        viewPagerAdapter!!.addView(OnePageView(findViewById<View>(R.id.one_view_page_user), this))
        viewPagerAdapter!!.addView(TwoPageView(findViewById<View>(R.id.two_view_page_user), this))
        viewPager!!.adapter = viewPagerAdapter

    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

}