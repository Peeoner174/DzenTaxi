package com.peeoner174.msi.oneapril2.dzen.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.peeoner174.msi.oneapril2.R
import com.peeoner174.msi.oneapril2.dzen.data.model.Gallery
import java.util.ArrayList

class GalleryAdapter(internal var context: Context, data: MutableList<Gallery>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var data: MutableList<Gallery> = ArrayList()

    init {
        this.data = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(
                R.layout.item_gallery, parent, false)

        return MyItemHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        //Дополнительные опции для glide`a
        val ro = RequestOptions()
        ro.placeholder(R.drawable.placeholder)
        ro.error(R.drawable.placeholder)

        Glide.with(context)
                .applyDefaultRequestOptions(ro)
                .load(data[position].url)
                .transition(DrawableTransitionOptions.withCrossFade())
                .thumbnail(0.5f)
                .into((holder as MyItemHolder).mImg)
    }

    fun updateData(data: List<Gallery>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MyItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mImg: ImageView

        init {

            mImg = itemView.findViewById<View>(R.id.item_img) as ImageView
        }

    }

}
