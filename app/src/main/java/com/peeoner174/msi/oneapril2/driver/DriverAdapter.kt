package com.peeoner174.msi.oneapril2.driver



import android.content.Context
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import com.peeoner174.msi.oneapril2.driver.model.Driver
import kotlinx.android.synthetic.main.item_driver.view.*
import com.bumptech.glide.Glide
import com.peeoner174.msi.oneapril2.R


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
 * [DriverAdapter] Преобразует список объектов [Driver], [Driver.List]
 * в наследников [View] для отрисовки
 */
class DriverAdapter(private val drivers: ArrayList<Driver>, private val  mCtx: Context)
    : RecyclerView.Adapter<DriverAdapter.DriverViewHolder>() {

    /**
     * @return количество элементов для отображения
     */
    override fun getItemCount(): Int = drivers.count()

    /**
     * Создаёт [RecyclerView.ViewHolder] который хранит в себе [View] для переиспользования
     * @param parent ссылка на контейнер в котором будут хранится [View]
     * @param viewType тип создаваемого контента, определяется в методе [RecyclerView.Adapter.getItemViewType]
     * @return DriverViewHolder с PhotoView внутри
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DriverViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_driver, parent, false)
        return DriverViewHolder(view)
    }

    /**
     * Выставляем данные в [View]
     * либо обновляем в случае если [View] уже был создан
     * это нужно обязательно иметь ввиду т.к. [RecyclerView.ViewHolder]
     * хранит в себе [View] в последнем её состоянии
     * @param holder объект который хранит в себе [View]
     * @param position позиция элемента в списке
     */
    override fun onBindViewHolder(holderDriver: DriverViewHolder, position: Int) {
        // Получем объект Driver из списка по позиции
        holderDriver.bind(drivers[position])
        /**Инструмент для загрузки изображений по сети
         * [mCtx] - контекст куда должна загрузиться картинка
         * [drivers[position].image] - internet Url
         * [holderDriver.targetImageView] - в какую позицию разметки подставить изображени **/
            Glide
                .with(mCtx)
                .load(drivers[position].image)
                .into(holderDriver.targetImageView)
        //Обрабатываем нажатие на клавишу вызова всплывающего меню
        val clickListener =View.OnClickListener { view ->
            /**[mCtx] - Контекст, в котором откроется pop-up меню
             * [View] - Элемент View, по нажатию на который откроется меню
             * **/
            var popup = PopupMenu(mCtx, holderDriver.itemView.buttonMenuDriver)
            popup.inflate(R.menu.options_menu)

            popup.show()
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.menu1 -> { Toast.makeText(mCtx, "Write your message here"+position, Toast.LENGTH_LONG).show()}
                }
                false
            }
        }

        holderDriver.button.setOnClickListener(clickListener)
    }

    fun updateData(drivers: List<Driver>) {
        this.drivers.clear()
        this.drivers.addAll(drivers)
        notifyDataSetChanged()
    }

    /**
     * Класс для хранения ссылки на [View]
     * нужен для того что-бы [RecyclerView]
     * мог переиспользвать [View]
     * для эфективного использования памяти
     * @param view Публичная ссыла на [PhotoView] для обновления данных
     */
    class DriverViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        //Отображение кнопки всплывающего меню
        val button = itemView.findViewById<ImageButton>(R.id.buttonMenuDriver) as ImageButton
        //Все следующие данные берутся из интернета
        /**[itemView] - поле ViewHolder`а где храниться View текущей ящейки
         * **/
        val targetImageView = itemView.findViewById<ImageView>(R.id.imageViewImage) as ImageView

        fun bind(driver: Driver) {

            itemView.textViewName.text = driver.name
            itemView.textViewCar.text = driver.car
            itemView.textViewRating.text = driver.rating
            itemView.textViewPrice.text = driver.price
        }
    }
}



