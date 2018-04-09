package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.ui.adapter.RecViewNoteAdapter
import kotlinx.coroutines.experimental.android.UI
import com.peeoner174.msi.oneapril2.dzen.data.model.Note
import com.peeoner174.msi.oneapril2.dzen.producer.NoteDataLoaderWeb
import kotlinx.android.synthetic.main.activity_note.*
import kotlinx.coroutines.experimental.launch

/**Записки поездки **/

class NoteActivity: AppCompatActivity() {

    private var adapter = RecViewNoteAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = NoteDataLoaderWeb()
    private var url: String ?= null // var url = "https://raw.githubusercontent.com/Peeoner174/DzenTaxi/master/SimpleNoteJson"

    /**
     * Стартовый медот Activity
     * с него начинается жизненный цикл компоенента
     * https://developer.android.com/guide/components/activities/activity-lifecycle.html
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Устанавливаем Activity
        setContentView(R.layout.activity_note)
        //Настраиваем toolbar
        setToolbar()
        val simpleProgressBar =  findViewById(R.id.simpleProgressBar2) as ProgressBar


        //Передача данных между активити, получает данные, заносит их в Bundle
        val intent: Bundle? = intent.extras
        url = intent?.getString("URL_Note")
        //Log.d("URL note", url)

        initRecyclerView(findViewById(R.id.rv_note_list))

        //Выносим загрузку данных в отдельный поток
        launch(UI) {
            simpleProgressBar.visibility = View.VISIBLE
            val job = dataLoader.loadNote(url)
            showUsers(job.await())
            simpleProgressBar.visibility = View.INVISIBLE
        }
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

    private fun initRecyclerView(recyclerView: RecyclerView) {
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = layoutManager
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.adapter = adapter
    }

    private fun showUsers(notes: List<Note>) {
        adapter.updateData(notes)
    }

    private fun setToolbar(){
        val toolbarG = findViewById<Toolbar>(R.id.toolbar_note)
        toolbarG.setTitleTextColor(Color.BLACK)
        toolbarG.setLogo(R.drawable.ic_splash_toolbar)
        toolbarG.setTitle(R.string.app_name)
        toolbarG.setSubtitle(R.string.notes)
        setSupportActionBar(toolbarG)
    }
}
