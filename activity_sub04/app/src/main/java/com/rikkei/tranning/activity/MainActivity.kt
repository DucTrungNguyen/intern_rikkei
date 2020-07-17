package com.rikkei.tranning.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.rikkei.tranning.activity.`interface`.myInterface
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity()  {

    private var isInA : Boolean = true;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val aFragment = AFragment()
        val bFragment = BFragment()

        if ( savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_main, aFragment)
                .commit()

        }
        btnGoToB.setOnClickListener {
            if ( isInA){

                goToFragmentB(it, bFragment)
                isInA = false;
                btnGoToB.text =  "Go back Fragment A"
            }else {
                goBackFragmentA(aFragment)
                isInA = true
                btnGoToB.text =  "Go to Fragment B"

            }

        }
    }



    private fun goToFragmentB(view : View, bFragment : Fragment){


        supportFragmentManager
            .beginTransaction()
            .addToBackStack("fA")
            .replace(R.id.fragment_main, bFragment)
            .addToBackStack(null)
            .commit()


    }
    private fun goBackFragmentA(aFragment : Fragment){


        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_main, aFragment)
            .addToBackStack(null)
            .commit()

    }
}