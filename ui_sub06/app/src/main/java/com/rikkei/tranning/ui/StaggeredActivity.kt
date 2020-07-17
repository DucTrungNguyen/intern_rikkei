package com.rikkei.tranning.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.rikkei.tranning.ui.adapter.ItemAdapter
import com.rikkei.tranning.ui.adapter.StaggeredAdapter
import com.rikkei.tranning.ui.models.ItemModel
import kotlinx.android.synthetic.main.activity_linear.*
import kotlinx.android.synthetic.main.activity_staggered.*

class StaggeredActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_staggered)

        val listItem = buildItem(100)
        staggeredGrid.adapter = StaggeredAdapter(listItem)
        staggeredGrid.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        staggeredGrid.setHasFixedSize(true)

    }

    private fun buildItem(size : Int) : List<ItemModel>{
        val listItem =  ArrayList<ItemModel>()

        for( i in 0 until  size){
            val drawable = when ( i % 3){
                0-> R.drawable.p1
                1-> R.drawable.p2
                else -> R.drawable.p3
            }

            listItem.add(ItemModel(drawable, "This is title item $i", "This is content item $i"))
        }
        return  listItem

    }
}