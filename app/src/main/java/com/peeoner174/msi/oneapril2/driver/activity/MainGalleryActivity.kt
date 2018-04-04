package com.peeoner174.msi.oneapril2.driver.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.View

import com.peeoner174.msi.oneapril2.driver.adapter.GalleryAdapter
import com.peeoner174.msi.oneapril2.driver.model.Gallery
import com.peeoner174.msi.oneapril2.Gallery.RecyclerItemClickListener
import com.peeoner174.msi.oneapril2.R

import java.util.ArrayList

//Активити главного окна галереи

class MainGalleryActivity : AppCompatActivity() {

    internal lateinit var mAdapter: GalleryAdapter
    internal lateinit var mRecyclerView: RecyclerView

    internal var data = ArrayList<Gallery>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_galley)

        for (i in IMGS.indices) {

            val gallery = Gallery()
            gallery.name = "Image $i"
            gallery.url = IMGS[i]
            data.add(gallery)

        }

        val toolbarG = findViewById<Toolbar>(R.id.toolbar_gallery)
        setSupportActionBar(toolbarG)

        mRecyclerView = findViewById<View>(R.id.list) as RecyclerView
        mRecyclerView.layoutManager = GridLayoutManager(this, 3)
        mRecyclerView.setHasFixedSize(true)


        mAdapter = GalleryAdapter(this@MainGalleryActivity, data)
        mRecyclerView.adapter = mAdapter

        mRecyclerView.addOnItemTouchListener(RecyclerItemClickListener(this,
                RecyclerItemClickListener.OnItemClickListener { view, position ->
                    val intent = Intent(this@MainGalleryActivity, DetailGalleryActivity::class.java)
                    intent.putParcelableArrayListExtra("data", data)
                    intent.putExtra("pos", position)
                    startActivity(intent)
                }))

    }

    companion object {

        var IMGS = arrayOf("https://images.unsplash.com/photo-1444090542259-0af8fa96557e?q=80&fm=jpg&w=1080&fit=max&s=4b703b77b42e067f949d14581f35019b", "https://images.unsplash.com/photo-1439546743462-802cabef8e97?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1437651025703-2858c944e3eb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1431538510849-b719825bf08b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1434873740857-1bc5653afda8?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1439396087961-98bc12c21176?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1433616174899-f847df236857?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1438480478735-3234e63615bb?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300", "https://images.unsplash.com/photo-1438027316524-6078d503224b?dpr=2&fit=crop&fm=jpg&h=725&q=50&w=1300")
    }

}
