package com.peeoner174.msi.oneapril2.driver.activity


import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.driver.adapter.RecViewNoteAdapter
import kotlinx.coroutines.experimental.android.UI
import com.peeoner174.msi.oneapril2.driver.model.Note
import com.peeoner174.msi.oneapril2.driver.producer.NoteDataLoaderWeb


import kotlinx.coroutines.experimental.launch
//Записи внутри поездки

/**
 * Компонент для визуального взаимодействия с пользователем
 * отображает наши View на экране
 */
class NoteActivity: AppCompatActivity() {

    private var adapter = RecViewNoteAdapter(ArrayList(0), this)
    private val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
    private val dataLoader = NoteDataLoaderWeb()

    /**
     * Стартовый медот Activity
     * с него начинается жизненный цикл компоенента
     * https://developer.android.com/guide/components/activities/activity-lifecycle.html
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Устанавливаем Activity
        setContentView(R.layout.note_activity)

        initRecyclerView(findViewById(R.id.rv_note_list))
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
            val job = dataLoader.loadNote()
            showUsers(job.await())
        }
    }

    private fun showUsers(notes: List<Note>) {
        adapter.updateData(notes)
    }
}
