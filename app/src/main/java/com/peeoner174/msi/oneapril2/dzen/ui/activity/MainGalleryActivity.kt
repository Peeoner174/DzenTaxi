package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import com.peeoner174.msi.oneapril2.App
import com.peeoner174.msi.oneapril2.dzen.ui.adapter.GalleryAdapter
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery
import com.peeoner174.msi.oneapril2.dzen.util.RecyclerItemClickListener
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.producer.GalleryDataLoaderWeb
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlin.collections.ArrayList
import com.peeoner174.msi.oneapril2.MySingleton

/**Главное окно галереи**/

class MainGalleryActivity : AppCompatActivity() {

    private var mAdapter = GalleryAdapter(this@MainGalleryActivity, ArrayList(0))
    private lateinit var mRecyclerView: RecyclerView
    private val galleryDataLoaderWeb = GalleryDataLoaderWeb()
    private var data = ArrayList<Gallery>()
    private var url: String ?= null ////var url = "https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/GalleryJson"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_galley)
        setToolbar()
        val simpleProgressBar = findViewById<ProgressBar>(R.id.simpleProgressBar1)

        val intent: Bundle? = intent.extras
        url = intent?.getString("URL_Gallery")
        //Log.d("URL", url)

        launch(UI) {
            simpleProgressBar.visibility = View.VISIBLE

            val cashJob = galleryDataLoaderWeb.loadGalleryFromCache(application as App).await()

            val job = galleryDataLoaderWeb.loadGallery(url)
            showGallery(job.await())

            simpleProgressBar.visibility = View.INVISIBLE
            galleryDataLoaderWeb.loadToCashe(application as App, job.await())

        }

        mRecyclerView = findViewById<RecyclerView>(R.id.list)
        initRecyclerView(mRecyclerView)
    }

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(this, 3) as RecyclerView.LayoutManager?
        recyclerView.adapter = mAdapter
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
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showGallery(notes: List<Gallery>) {

          data.addAll(notes) //функия putParcelableArrayListExtra требует ArrayList
          mAdapter.updateData(notes)

          //Вешаем слушателя на item RecyclerView
          mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(this,
                    RecyclerItemClickListener.OnItemClickListener { view, position ->
                        val intent = Intent(this@MainGalleryActivity, DetailGalleryActivity::class.java)
                        intent.putParcelableArrayListExtra("data", data)//для быстрой сериализации и передачи сложных объектов
                        intent.putExtra("pos", position)
                        startActivity(intent)
                    }))
        }

    private fun setToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar_gallery)
        toolbar.setTitleTextColor(Color.BLACK)
        toolbar.setLogo(R.drawable.ic_splash_toolbar)
        toolbar.setTitle(R.string.app_name)
        toolbar.setSubtitle(R.string.album)
        setSupportActionBar(toolbar)
    }
}




