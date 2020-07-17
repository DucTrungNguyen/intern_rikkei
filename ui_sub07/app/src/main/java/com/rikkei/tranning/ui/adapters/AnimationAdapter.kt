package com.rikkei.tranning.ui.adapters

import android.app.ActivityOptions
import android.content.Intent
import android.util.Pair
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rikkei.tranning.ui.DetailActivity
import com.rikkei.tranning.ui.R
import com.rikkei.tranning.ui.models.DetailModel
import kotlinx.android.synthetic.main.listitem.view.*
import java.util.*

class AnimationAdapter(val list: List<DetailModel>) : RecyclerView.Adapter<AnimationAdapter.ViewHolder>(){

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image = itemView.image;
        val title = itemView.title


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val  itemView = LayoutInflater.from(parent.context).inflate(R.layout.listitem, parent, false)
        return  AnimationAdapter.ViewHolder(itemView)

    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val current = list[position]
        holder.image.setImageResource(current.image)
        holder.title.text = current.title
//        holder.itemView.setOnClickListener{
//            val adapterPosition = holder.adapterPosition
//            if ( adapterPosition == RecyclerView.NO_POSITION){
//                return@setOnClickListener
//            }
//            val intent =  Intent(it.context, DetailActivity::class.java)
//            intent.putExtra("position", adapterPosition)
//
//            it.context.startActivity(intent);
//
//
//        }

    }


}