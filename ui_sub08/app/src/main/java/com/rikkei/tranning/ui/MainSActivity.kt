package com.rikkei.tranning.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.graphics.drawable.GradientDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.Gravity
import android.view.OrientationEventListener
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main_s.*
import java.util.*

class MainSActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_s)

        btnPickTopping.setOnClickListener {
            buildPickTopping(it)

        }
        btnWarring.setOnClickListener {
            buildWarring(it)
        }
        btnBrightness.setOnClickListener {
            buildBrightness(it)
        }
        btnTextLimit.setOnClickListener {
            buildTextLimit(it)
        }

        btnTimePicker.setOnClickListener {
            pickTime(it)
        }
        btnDatePicker.setOnClickListener {
            pickDate(it)
        }
    }

    private fun pickDate(it: View) {
        val cal = Calendar.getInstance()
        val dateSetPicker = DatePickerDialog.OnDateSetListener {
                _, year, month, dayOfMonth ->
            cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
            cal.set(Calendar.MONTH, month)
            cal.set(Calendar.YEAR, year)
        }
        DatePickerDialog(it.context, R.style.ThemeOverlay_AppCompat_Dialog, dateSetPicker, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH))
            .show()

    }

    private fun pickTime(it: View) {
        val cal = Calendar.getInstance()
        val timeSetPicker = TimePickerDialog.OnTimeSetListener{
                _, hourOfDay, minute ->
            cal.set(Calendar.HOUR_OF_DAY, hourOfDay)
            cal.set(Calendar.MINUTE, minute)
//            time
        }
        TimePickerDialog(it.context, timeSetPicker, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true)
            .show()

    }

    private fun buildTextLimit(it: View) {


        var builder : AlertDialog.Builder = AlertDialog.Builder(it.context)

        val numberPicker : NumberPicker = NumberPicker(it.context)
        numberPicker.maxValue = 1000
        numberPicker.minValue = 100

        val mess : TextView = TextView(it.context)
        mess.text = "Set numbetr off message to save"

        val linearLayout : LinearLayout = LinearLayout(it.context)
        linearLayout.gravity = Gravity.CENTER
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.setPadding(60,30,60,30)

        linearLayout.addView(mess)
        linearLayout.addView(numberPicker)


        builder.setTitle("Set text limit")
            .setIcon(R.drawable.ic_baseline_save_alt_24)
            .setView(linearLayout)
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
            val  dialog :AlertDialog = builder.create()
            dialog.show()



    }

    private fun buildBrightness(it: View) {
        var builder :AlertDialog.Builder = AlertDialog.Builder(ContextThemeWrapper(it.context, android.R.style.ThemeOverlay_Material_Dark_ActionBar))

        val seekBar :SeekBar = SeekBar(it.context)

//        numberPicker.textColor
        val linearLayout : LinearLayout
        val brightness = arrayOf("Automatic Brightness")
        builder.setIcon(R.drawable.ic_baseline_wb_sunny_24)
            .setTitle("Brightness")
            .setView(seekBar)
            .setMultiChoiceItems(brightness, null, DialogInterface.OnMultiChoiceClickListener(){
                    dialogInterface: DialogInterface, i: Int, b: Boolean ->
                Toast.makeText(this, brightness[i] , Toast.LENGTH_SHORT).show()

            })
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
            val  dialog :AlertDialog = builder.create()
            dialog.show()



    }


    private  fun  buildWarring(view : View){

        val builder: AlertDialog.Builder = AlertDialog.Builder(ContextThemeWrapper(view.context, android.R.style.ThemeOverlay_Material_Dark_ActionBar))

        builder.setIcon(R.drawable.ic_baseline_warning_24)
            .setTitle("Erase USB Storage")
            .setMessage("Your data will be lost")
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })

            val dialog: AlertDialog = builder.create()

//        dialog.window.decorView.background.colorFilter
            dialog.show()

    }

    private fun buildPickTopping(view : View){
        // setup the alert builder

        // setup the alert builder
        val builder: AlertDialog.Builder = AlertDialog.Builder(view.context)

        val toppings =
            arrayOf("Onion", "Lettuce", "Tomato")
        builder.setTitle("Pick Your Topping")
            .setMultiChoiceItems(toppings, null, DialogInterface.OnMultiChoiceClickListener(){
                    dialogInterface: DialogInterface, i: Int, b: Boolean ->
                Toast.makeText(this, toppings[i] , Toast.LENGTH_SHORT).show()

            })
            .setPositiveButton("OK", DialogInterface.OnClickListener { dialog, which ->  })
            .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, which ->  })
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}