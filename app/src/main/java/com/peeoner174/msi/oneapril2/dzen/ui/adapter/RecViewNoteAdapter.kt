package com.peeoner174.msi.oneapril2.dzen.ui.adapter


import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.data.model.Note
import kotlinx.android.synthetic.main.item_note.view.*

class RecViewNoteAdapter(private val notes: ArrayList<Note>, private val  mCtx: Context)
    : RecyclerView.Adapter<RecViewNoteAdapter.NoteViewHolder>() {

    /**
     * @return количество элементов для отображения
     */
    override fun getItemCount(): Int = notes.count()

    /**
     * Создаёт [RecyclerView.ViewHolder] который хранит в себе [View] для переиспользования
     * @param parent ссылка на контейнер в котором будут хранится [View]
     * @param viewType тип создаваемого контента, определяется в методе [RecyclerView.Adapter.getItemViewType]
     * @return DriverViewHolder с PhotoView внутри
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        return NoteViewHolder(view)
    }

    /**
     * Выставляем данные в [View]
     * либо обновляем в случае если [View] уже был создан
     * это нужно обязательно иметь ввиду т.к. [RecyclerView.ViewHolder]
     * хранит в себе [View] в последнем её состоянии
     * @param holder объект который хранит в себе [View]
     * @param position позиция элемента в списке
     */
    override fun onBindViewHolder(holderNote: NoteViewHolder, position: Int) {
        // Получем объект из списка по позиции
        holderNote.bind(notes[position])
    }

    fun updateData(notes: List<Note>) {
        this.notes.clear()
        this.notes.addAll(notes)
        notifyDataSetChanged()
    }

    /**
     * Класс для хранения ссылки на [View]
     * нужен для того что-бы [RecyclerView]
     * мог переиспользвать [View]
     * для эфективного использования памяти
     * @param view Публичная ссыла на [View] для обновления данных
     */
    class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(note: Note) {

            itemView.textViewTitleNote.text = note.title
            itemView.textViewNote.text = note.note_text
        }
    }
}



