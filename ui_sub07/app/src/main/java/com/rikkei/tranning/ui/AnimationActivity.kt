package com.rikkei.tranning.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.rikkei.tranning.ui.adapters.AnimationAdapter
import com.rikkei.tranning.ui.adapters.ItemAdapter
import com.rikkei.tranning.ui.models.DetailModel
import com.rikkei.tranning.ui.models.InforAndroidModel
import kotlinx.android.synthetic.main.activity_animation.*

class AnimationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)


        val list= builList()
        recyclerDetail.layoutManager = GridLayoutManager(this, 3)
        recyclerDetail.adapter= AnimationAdapter(list)
        recyclerDetail.setHasFixedSize(true)


    }

    private fun builList() : List<DetailModel>{
        val listItem = ArrayList<DetailModel>()
        listItem.add(DetailModel(R.drawable.image_1, "Detail 1"))
        listItem.add(DetailModel(R.drawable.image_2, "Detail 2"))
        listItem.add(DetailModel(R.drawable.image_1, "Detail 3"))
        listItem.add(DetailModel(R.drawable.image_2, "Detail 4"))
        listItem.add(DetailModel(R.drawable.image_1, "Detail 5"))
        listItem.add(DetailModel(R.drawable.image_2, "Detail 6"))




        return listItem




    }
}