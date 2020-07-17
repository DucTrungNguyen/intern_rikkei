package com.rikkei.tranning.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.tranning.ui.R
import com.rikkei.tranning.ui.models.ItemModel
import kotlinx.android.synthetic.main.itemcard.view.*
import java.util.*

class ItemAdapter(val itemList : List<ItemModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){
    private val mRandom = Random()
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.imageView
        val txtTitle : TextView = itemView.txtTitle
        val  txtContent : TextView = itemView.txtContent

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.itemcard,parent, false )
        return ItemViewHolder(itemView)

    }

    override fun getItemCount(): Int {
       return  itemList.count()
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = itemList[position]


        holder.imageView.setImageResource(currentItem.imageResource)

        holder.txtTitle.text = currentItem.title
        holder.txtContent.text = currentItem.content

    }


}