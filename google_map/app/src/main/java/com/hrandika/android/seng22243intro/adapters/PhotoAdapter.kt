package com.hrandika.android.seng22243intro.adapters

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hrandika.android.seng22243intro.R
import com.hrandika.android.seng22243intro.model.Photo
import java.net.URL


class PhotoAdapter(private val mList: List<Photo>) :
    RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]

        // sets the image to the imageview from our itemHolder class
//        val newurl = URL(ItemsViewModel.thumbnailUrl)
//        val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
//        holder.imageView.setImageBitmap(mIcon_val)

        // sets the text to the textview from our itemHolder class
        holder.textView.text = itemsViewModel.title
        holder.textViewUrl.text = itemsViewModel.url
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val textView: TextView = itemView.findViewById(R.id.textView)
        val textViewUrl = itemView.findViewById<TextView>(R.id.textview_url)
    }
}