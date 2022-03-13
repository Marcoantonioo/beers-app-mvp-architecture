package com.example.beersappmvparchitecture.presentation.beer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beersappmvparchitecture.R
import com.example.beersappmvparchitecture.presentation.beer.model.BeerView
import com.example.beersappmvparchitecture.utils.fadeInAnimation

class BeerListAdapter(
    private val context: Context,
) : RecyclerView.Adapter<BeerListAdapter.ViewHolder>() {

    var list: List<BeerView> = emptyList()
    var withAnimation = true

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.textViewName.text = item.name

        setupGlide(holder, item)

        //if (withAnimation) {
        //    holder.itemView.fadeInAnimation()
        //}
    }

    private fun setupGlide(holder: ViewHolder, beer: BeerView) {
        Glide.with(context)
            .load(beer.imageUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.imageView)
    }

    override fun getItemCount() = list.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewName: TextView = itemView.findViewById(R.id.textViewName)
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
        val buttonDetails: Button = itemView.findViewById(R.id.buttonDetails)
    }
}
