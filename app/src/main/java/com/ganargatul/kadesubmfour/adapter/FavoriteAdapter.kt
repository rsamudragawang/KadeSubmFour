package com.ganargatul.kadesubmfour.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ganargatul.kadesubmfour.R
import com.ganargatul.kadesubmfour.db.FavoriteItems

class FavoriteAdapter (private  val context: Context, private val items: List<FavoriteItems>, private val listener: (FavoriteItems) -> Unit): RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val name = view.findViewById<TextView>(R.id.title_items)

        fun bindItem(items: FavoriteItems, listener: (FavoriteItems) -> Unit){
            name.text = items.EVENT_NAME_
            itemView.setOnClickListener { listener(items) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.next_event_item,parent,false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position],listener)
    }
}