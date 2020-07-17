package com.rikkei.tranning.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.palette.graphics.Palette
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.rikkei.tranning.ui.adapters.ItemAdapter
import com.rikkei.tranning.ui.models.InforAndroidModel
import kotlinx.android.synthetic.main.activity_android_version.*

class AndroidVersionActivity : AppCompatActivity() {

    private  var appBarExpanded : Boolean = true
    private lateinit var collapsedMenu : Menu
    private lateinit var appBarLayout : AppBarLayout
    private lateinit var collapsingToolbar: CollapsingToolbarLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_android_version)


        val list = builList()
        recyclerItem.adapter = ItemAdapter(list)
        recyclerItem.layoutManager = LinearLayoutManager(this)
        recyclerItem.setHasFixedSize(true)


        val toolbar = findViewById<Toolbar>(R.id.anim_toolbar)
        setSupportActionBar(toolbar)
        if (supportActionBar != null) supportActionBar!!.setDisplayHomeAsUpEnabled(true) // button back

        appBarLayout = findViewById<AppBarLayout>(R.id.appBar)

        collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsingToolBar)
        collapsingToolbar.setTitle("Android Version")

//        val bitmap = BitmapFactory.decodeResource(
//            resources,
//            R.drawable.header
//        )
//
//        Palette.from(bitmap).generate { palette ->
////            val vibrantColor = palette!!.getVibrantColor("#3F51B5")
////            collapsingToolbar.setContentScrimColor(vibrantColor)
////            collapsingToolbar.setStatusBarScrimColor(R.color.black_trans80)
//        }

        appBar.addOnOffsetChangedListener(OnOffsetChangedListener { appBarLayout, verticalOffset ->

            //  Vertical offset == 0 indicates appBar is fully expanded.
            if (Math.abs(verticalOffset) > 200) {
                appBarExpanded = false
                invalidateOptionsMenu()
            } else {
                appBarExpanded = true
                invalidateOptionsMenu()
            }
        })
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        if (collapsedMenu != null
            && (!appBarExpanded || collapsedMenu.size() != 1)
        ) {
            //collapsed
            collapsedMenu.add("Add")
                .setIcon(R.drawable.ic_baseline_add_circle_24)
                .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM)
        } else {
            //expanded
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        if (menu != null) {
            collapsedMenu = menu
        }
        return true

    }


    private fun builList() : List<InforAndroidModel>{
        val listItem = ArrayList<InforAndroidModel>()
        listItem.add(InforAndroidModel("C", "CupCake", "A small cake designed to serve one person, which may be baked in a small thin paper or aluminum cup. As with larger cakes, icing and other cake decorations, such as candy, may be applied." ))
        listItem.add(InforAndroidModel("D", "Donut", "A type of fried dough confectionery or dessert food." ))
        listItem.add(InforAndroidModel("E", "Eclair", "An oblong pastry made with choux dough filled with a cream and topped with icing." ))
        listItem.add(InforAndroidModel("F", "Froyo", "Frozen yogurt is a frozen dessert made with yogurt and sometimes other dairy products. It is usually more tart than ice cream, as well as being lower in fat. It is different from ice milk and conventional soft serve" ))
        listItem.add(InforAndroidModel("G", "Gingerbread", "Refers to a broad category of baked goods, typically flavored with ginger, cloves, nutmeg or cinnamon and sweetened with honey" ))
        listItem.add(InforAndroidModel("H", "Honeycomb", "A mass of hexagonal wax cells built by honey bees in their nests to contain their larvae and stores of honey and pollen." ))
        listItem.add(InforAndroidModel("I", "Ice-cream Sandwich", "A frozen dessert consisting of ice cream between two wafers, cookies, or other similar biscuit." ))
        listItem.add(InforAndroidModel("J", "Jelly Bean", "Small bean-shaped sugar candies with soft candy shells and thick gel interiors. The confection comes in a wide variety of colors and flavors." ))
        listItem.add(InforAndroidModel("K", "Kitkat", "A chocolate-covered wafer bar confection created by Rowntree of York, England, and is now produced globally by Nestle." ))
        listItem.add(InforAndroidModel("L", "Lollipop", "A type of confectionery consisting of a sweetmeat of hard candy or water-ice mounted on a stick and intended for sucking or licking." ))
        listItem.add(InforAndroidModel("M", "Marshmallow", "A sugar-based confection that, in its modern form, typically consists of sugar, water and gelatin which is whipped to a spongy consistency, molded into small cylindrical pieces, and coated with corn starch." ))
        listItem.add(InforAndroidModel("N", "Nougat", "A family of confections made with sugar or honey, roasted nuts, whipped egg whites, and sometimes chopped candied fruit. The consistency of nougat is chewy, and it is used in a variety of candy bars and chocolates." ))

        return  listItem
    }
}