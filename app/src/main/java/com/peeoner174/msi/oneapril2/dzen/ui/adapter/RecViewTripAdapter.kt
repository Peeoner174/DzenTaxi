package com.peeoner174.msi.oneapril2.dzen.ui.adapter

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageButton
import android.widget.ImageView
import kotlinx.android.synthetic.main.item_trip.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.peeoner174.msi.oneapril2.dzen.ui.activity.MainGalleryActivity
import com.peeoner174.msi.oneapril2.dzen.ui.activity.NoteActivity
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.data.model.Trip
import com.bumptech.glide.request.RequestOptions
import com.peeoner174.msi.oneapril2.App
import java.text.FieldPosition

/**
 * Adapter - паттерн проектирования для связывания данных с представлением
 * Обязанности adapter`а в recyclerView:
 * ********создание ViewHolder’ов
 * ********заполнение ViewHolder’ов информацией
 * ********уведомление RecyclerView о том какие элементы изменились.
 * ********обработка касаний
 * ********частичное обновление данных
 * ********управление количеством ViewType’ов
 * ********информация о переиспользовании ViewHolder’а
 * [Adapter] Преобразует список объектов указанного типа,
 * в наследников [View] для отрисовки
 */
class RecViewTripAdapter(private val trips: ArrayList<Trip>, private val  mCtx: Context)
    : RecyclerView.Adapter<RecViewTripAdapter.TripViewHolder>() {


    /**
     * @return количество элементов для отображения
     */
    override fun getItemCount(): Int = trips.count()

    /**
     * Создаёт [RecyclerView.ViewHolder] который хранит в себе [View] для переиспользования
     * @param parent ссылка на контейнер в котором будут хранится [View]
     * @param viewType тип создаваемого контента, определяется в методе [RecyclerView.Adapter.getItemViewType]
     * @return ViewHolder с View внутри
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TripViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_trip, parent, false)
        return TripViewHolder(view)
    }

    /**
     * Выставляем данные в [View]
     * либо обновляем в случае если [View] уже был создан
     * это нужно обязательно иметь ввиду т.к. [RecyclerView.ViewHolder]
     * хранит в себе [View] в последнем её состоянии
     * @param holder объект который хранит в себе [View]
     * @param position позиция элемента в списке
     */
    override fun onBindViewHolder(holder: TripViewHolder, position: Int) {
        // Получем объект из списка по позиции
        holder.bind(trips[position])

        val ro = RequestOptions()
        ro.error(R.drawable.placeholder)
        /**Инструмент для загрузки изображений по сети
         * [mCtx] - контекст куда должна загрузиться картинка
         * [drivers[position].image] - internet Url
         * [holderDriver.targetImageView] - в какую позицию разметки подставить изображени **/
        //Библиотека для скругления ImageView: https://github.com/hdodenhof/CircleImageView
        Glide
                .with(mCtx)
                .applyDefaultRequestOptions(ro)
                .load(trips[position].user_image)
                .transition(DrawableTransitionOptions.withCrossFade())//смузи появление картинки
                .into(holder.userImageView)

        Glide
                .with(mCtx)//Привязывает загрузку картинки к жизненному циклу контекста
                .applyDefaultRequestOptions(ro)//Дополнительные опции для glide
                .load(trips[position].photo)
                .transition(DrawableTransitionOptions.withCrossFade())//смузи появление картинки
                .into(holder.targetImageView)


        //Обрабатывает нажатие на клавишу вызова всплывающего меню
        val clickListener =View.OnClickListener { view ->
            /**[mCtx] - Контекст, в котором откроется pop-up меню
             * [View] - Элемент View, по нажатию на который откроется меню
             * **/
            var popup = PopupMenu(mCtx, holder.itemView.buttonMenuTrip)
            popup.inflate(R.menu.trip_options_menu)

            popup.show()
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu1 -> {openGallery(trips[position].photo_gallery, trips[position].id)}
                    R.id.menu2 -> {openNotes(trips[position].notes)}
                }
                false
            }
        }

        holder.button.setOnClickListener(clickListener)
    }

    private fun openNotes(strNUrl: String) {

        val intent = Intent(mCtx, NoteActivity::class.java)
        intent.putExtra("URL_Note", strNUrl)
        startActivity(mCtx, intent, null)
    }

    private fun openGallery(strUrl: String, tripId: String) {

        val intent = Intent(mCtx, MainGalleryActivity::class.java)
        intent.putExtra("URL_Gallery", strUrl)
        intent.putExtra("idTrips", tripId)
        startActivity(mCtx, intent, null)

    }

    fun updateData(trips: List<Trip>) {
        this.trips.clear()
        this.trips.addAll(trips)
        notifyDataSetChanged()
    }

    /**
     * Класс для хранения ссылки на [View]
     * нужен для того что-бы [RecyclerView]
     * мог переиспользвать [View]
     * для эфективного использования памяти
     */
    class TripViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Отображение кнопки всплывающего меню
        val button = itemView.findViewById<ImageButton>(R.id.buttonMenuTrip) as ImageButton
        //Все следующие данные берутся из интернета
        /**[itemView] - поле ViewHolder`а где храниться View текущей ящейки
         * **/
        val targetImageView = itemView.findViewById<ImageView>(R.id.trip_imageViewImage) as ImageView
        val userImageView = itemView.findViewById<ImageView>(R.id.imageViewUser) as ImageView

        fun bind(trip: Trip) {

            itemView.textViewTitle.text = trip.title
            itemView.textViewdateTrip.text = trip.date
            itemView.textViewPlace.text = trip.place
        }
    }
}

