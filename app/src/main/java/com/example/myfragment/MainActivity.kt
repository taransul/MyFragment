package com.example.myfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        button_next_fragment.setOnClickListener {
            when (counter) {
                0 -> {
                    openFragment(FragmentOne.newInstance(), FragmentOne.TAG)
                    fragmentStringColor(R.string.red_fragment, R.color.my_red, R.color.my_green)
                }
                1 -> {
                    openFragment(FragmentTwo.newInstance(), FragmentTwo.TAG)
                    fragmentStringColor(R.string.green_fragment, R.color.my_green, R.color.my_blue)
                }
                2 -> {
                    openFragment(FragmentThree.newInstance(), FragmentThree.TAG)
                    fragmentStringColor(R.string.blue_fragment, R.color.my_blue, R.color.my_red)
                }
            }
            counter++
            if (counter >= 3) counter = 0
        }
    }

    private fun openFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(tag)
            .add(R.id.place_holder_for_fragment, fragment)
            .commit()
    }

    private fun fragmentStringColor(
        headingTextGetString: Int,
        headingSetBackgroundResource: Int,
        buttonSetTextColor: Int
    ) {
        heading_for_fragments.text = getString(headingTextGetString)
        heading_for_fragments.setBackgroundResource(headingSetBackgroundResource)
        button_next_fragment.setTextColor(getColor(buttonSetTextColor))
    }
}