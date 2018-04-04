package com.peeoner174.msi.oneapril2.driver.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
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
import com.peeoner174.msi.oneapril2.Gallery.DepthPageTransformer
import com.peeoner174.msi.oneapril2.driver.model.Gallery
import com.peeoner174.msi.oneapril2.R

import java.util.ArrayList

//Активити галереи (когда приближают изображение и смотрят по одной фото)

class DetailGalleryActivity : AppCompatActivity() {

    /**
     * The [android.support.v4.view.PagerAdapter] that will provide
     * fragments for each of the sections. We use a
     * [FragmentPagerAdapter] derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * [android.support.v4.app.FragmentStatePagerAdapter].
     */
    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    var data = ArrayList<Gallery>()
    internal var pos: Int = 0

    internal lateinit var toolbar: Toolbar

    /**
     * The [ViewPager] that will host the section contents.
     */
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gallery)

        toolbar = findViewById<View>(R.id.detail_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        data = intent.getParcelableArrayListExtra("data")
        pos = intent.getIntExtra("pos", 0)

        title = data[pos].name

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, data)
        // Set up the ViewPager with the sections adapter.
        mViewPager = findViewById<View>(R.id.container) as ViewPager
        mViewPager!!.setPageTransformer(true, DepthPageTransformer())

        mViewPager!!.adapter = mSectionsPagerAdapter
        mViewPager!!.currentItem = pos

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


    /**
     * A [FragmentPagerAdapter] that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    inner class SectionsPagerAdapter(fm: FragmentManager, data: ArrayList<Gallery>) : FragmentPagerAdapter(fm) {
        var data = ArrayList<Gallery>()

        init {
            this.data = data
        }

        override fun getItem(position: Int): Fragment {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position, data[position].name, data[position].url)
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return data.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return data[position].name
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    class PlaceholderFragment : Fragment() {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */

        internal var name: String? = null
        internal var url: String? = null
        internal var pos: Int = 0

        override fun setArguments(args: Bundle?) {
            super.setArguments(args)
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
             * Returns a new instance of this fragment for the given section
             * number.
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
