package com.peeoner174.msi.oneapril2.dzen.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import com.bumptech.glide.Glide
import com.peeoner174.msi.oneapril2.dzen.util.DepthPageTransformer
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery
import com.peeoner174.msi.oneapril2.R

import java.util.ArrayList

/**Активити галереи (когда приближают изображение и смотрят по одной фото)**/

class DetailGalleryActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    private var data = ArrayList<Gallery>()
    private var pos: Int = 0

    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gallery)

        var toolbar = findViewById<View>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        //Принимает переданные из другого активити объекты
        data = intent.getParcelableArrayListExtra("data")
        pos = intent.getIntExtra("pos", 0)
        //Динамически изменяем заголовок toolbar`a
        title = data[pos].name

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, data)

        initViewPager()
        mViewPager!!.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {

                title = data[position].name
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })
    }

    private fun initViewPager(){
        mViewPager = findViewById<View>(R.id.container1) as ViewPager
        mViewPager!!.setPageTransformer(true, DepthPageTransformer())
        mViewPager!!.adapter = mSectionsPagerAdapter
        mViewPager!!.currentItem = pos
    }

    //Создание кнопки меню на toolbar`e
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_detail, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    /**[FragmentPagerAdapter] - возвращает фрагмент соответствующий позиции**/
    inner class SectionsPagerAdapter(fm: FragmentManager, data: ArrayList<Gallery>) : FragmentStatePagerAdapter(fm) {
        var data = ArrayList<Gallery>()

        init {
            this.data = data
        }

        override fun getItem(position: Int): Fragment {
            //Инстанцирует фрагмент текущей страницы
            return PlaceholderFragment.newInstance(position, data[position].name, data[position].url)
        }

        override fun getCount(): Int {
            // Вычисляет колличество страниц у PageView
            return data.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return data[position].name
        }
    }

    class PlaceholderFragment : Fragment() {

        private var name: String? = null
        private var url: String? = null
        private var pos: Int = 0

        override fun setArguments(args: Bundle?) {
            super.setArguments(args)    //Получаем данные не заново из сети, а из предыдущего активити
            this.pos = args!!.getInt(ARG_SECTION_NUMBER)
            this.name = args.getString(ARG_IMG_TITLE)
            this.url = args.getString(ARG_IMG_URL)
        }

        override fun onStart() {
            super.onStart()

        }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                                  savedInstanceState: Bundle?): View? {
            val rootView = inflater.inflate(R.layout.fragment_detail_gallery, container, false)

            val imageView = rootView.findViewById<View>(R.id.detail_image) as ImageView

            Glide.with(activity!!).load(url).thumbnail(0.1f).into(imageView)

            return rootView
        }

        companion object {
            private val ARG_SECTION_NUMBER = "section_number"
            private val ARG_IMG_TITLE = "image_title"
            private val ARG_IMG_URL = "image_url"

            /**
             * Возвращает инстанс фрагмента указанной позиции
             */
            fun newInstance(sectionNumber: Int, name: String, url: String): PlaceholderFragment {
                val fragment = PlaceholderFragment()
                val args = Bundle()
                args.putInt(ARG_SECTION_NUMBER, sectionNumber)
                args.putString(ARG_IMG_TITLE, name)
                args.putString(ARG_IMG_URL, url)
                fragment.arguments = args
                return fragment
            }
        }

    }
}
