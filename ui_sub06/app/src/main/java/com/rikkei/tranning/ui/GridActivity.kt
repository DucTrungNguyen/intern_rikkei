package com.rikkei.tranning.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.rikkei.tranning.ui.adapter.ItemAdapter
import com.rikkei.tranning.ui.models.ItemModel
import kotlinx.android.synthetic.main.activity_grid.*
import kotlinx.android.synthetic.main.activity_linear.*

class GridActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid)

        val listItem = builItem(100)
        recyclerGrid.adapter = ItemAdapter(listItem)
        recyclerGrid.layoutManager = GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false)
        recyclerGrid.setHasFixedSize(true)
    }

    private fun  builItem(size: Int) : List<ItemModel>{
        val listItem = ArrayList<ItemModel>()
        for ( i in 0 until  size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_account_balance_24
                1 -> R.drawable.ic_baseline_account_circle_24
                else -> R.drawable.ic_baseline_add_shopping_cart_24
            }

            val item = ItemModel(drawable, "This is title item $i", "This is content item $i")
            listItem.add(item)
        }
        return listItem


    }
}