package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.peeoner174.msi.oneapril2.R
import kotlinx.android.synthetic.main.activity_taple.*
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import kotlinx.coroutines.experimental.android.UI
import com.peeoner174.msi.oneapril2.dzen.ui.adapter.RecViewTripAdapter
import com.peeoner174.msi.oneapril2.dzen.producer.TripDataLoaderWeb


import kotlinx.coroutines.experimental.launch

/**Экран с лентой всех поездок**/
class TapleActivity : AppCompatActivity() {

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
        setContentView(R.layout.activity_taple)
        setToolbar()

        val simpleProgressBar =  findViewById(R.id.simpleProgressBar) as ProgressBar

        navigation2.selectedItemId = R.id.navigation_dashboard
        navigation2.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        initRecyclerView(findViewById(R.id.rv_trips_list))

        //Выносим загрузку данных   в отдельный поток
        launch(UI) {
            simpleProgressBar.visibility = View.VISIBLE
            val cashJob = dataLoader.loadTripFromCache(application as App).await()
            if (cashJob.isNotEmpty()){
                showUsers(cashJob)
                Log.d("CashLoad", "CashLoad")
                simpleProgressBar.visibility = View.INVISIBLE
            } else {
                val webJob = dataLoader.loadTrip()
                showUsers(webJob.await())
                Log.d("WebLoad", "WebLoad")
                simpleProgressBar.visibility = View.INVISIBLE
                dataLoader.loadToCashe(application as App, webJob.await())

            }
        }

        Log.d("onCreate", "Cteate")
    }

    override fun onResume() {
        super.onResume()
        Log.d("onResume", "Resume")

    }

    private fun setToolbar(){
        val toolbarG = findViewById<Toolbar>(R.id.toolbar1)
        toolbarG.setTitleTextColor(Color.BLACK)
        toolbarG.setLogo(R.drawable.ic_splash_toolbar)
        toolbarG.setTitle(R.string.app_name)
        setSupportActionBar(toolbarG)
    }

    //Добавление кнопки меню в toolbar
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //Обработка нажатий на пункты меню в toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> {Toast.makeText(this,"Войти не удалось. Проверьте, что вы правильно вводите логин и пароль. Спасибо!", Toast.LENGTH_SHORT).show()
true}
            R.id.action_refresh -> {refresh()
                true}
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    private fun showUsers(trips: List<Trip>) {
        adapter.updateData(trips)
    }

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

    private fun refresh() =  launch(UI) {
        simpleProgressBar.visibility = View.VISIBLE
            val webJob = dataLoader.loadTrip()
            showUsers(webJob.await())
        Log.d("WebLoad", "WebLoad")
        simpleProgressBar.visibility = View.INVISIBLE
            dataLoader.loadToCashe(application as App, webJob.await())

        }
    }





