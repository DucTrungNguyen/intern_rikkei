package com.rikkei.tranning.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.tranning.ui.R
import com.rikkei.tranning.ui.models.InforAndroidModel
import kotlinx.android.synthetic.main.activity_android_version.view.*
import kotlinx.android.synthetic.main.itemcard.view.*

class ItemAdapter (val listItem :List<InforAndroidModel>) : RecyclerView.Adapter<ItemAdapter.ItemViewHoder>(){
    class ItemViewHoder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val firstChar = itemView.firstChar
        val txtTitle = itemView.txtTitle
        val txtContent = itemView.txtContent

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHoder {
        val  itemView =LayoutInflater.from(parent.context).inflate(R.layout.itemcard, parent, false)
        return  ItemAdapter.ItemViewHoder(itemView)

    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: ItemViewHoder, position: Int) {
        val currentItem = listItem[position]
        holder.firstChar.text = currentItem.firstChar
        holder.txtTitle.text = currentItem.title
        holder.txtContent.text = currentItem.content
    }


}