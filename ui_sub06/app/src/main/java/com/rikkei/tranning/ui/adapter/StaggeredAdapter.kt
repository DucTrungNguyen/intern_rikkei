package com.rikkei.tranning.ui.adapter

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.tranning.ui.R
import com.rikkei.tranning.ui.models.ItemModel
import kotlinx.android.synthetic.main.petcard.view.*
import java.util.*

class StaggeredAdapter(val list: List<ItemModel>) : RecyclerView.Adapter<StaggeredAdapter.ItemViewHolder>(){
    private val mRandom = Random()
    class  ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView : ImageView= itemView.imageViewPet
        val txtTitlePet : TextView = itemView.txtTitlePet
        val txtContentPet : TextView = itemView.txtContentPet



    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.petcard, parent, false)
        return  StaggeredAdapter.ItemViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentItem = list[position]

        holder.imageView.setImageResource(currentItem.imageResource)
        holder.txtTitlePet.text = currentItem.title
        holder.txtContentPet.text = currentItem.content
        holder.imageView.layoutParams.height = mRandom.nextInt(100) + 200

    }


}