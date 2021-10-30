package com.example.myfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        var i = 0
        button_next_fragment.setOnClickListener {
            when (i) {
                0 -> {
                    openFragment(FragmentOne.newInstance(), FragmentOne.TAG)
                    heading_for_fragments.text = getString(R.string.red_fragment)
                    heading_for_fragments.setBackgroundResource(R.color.my_red)
                    button_next_fragment.setTextColor(getColor(R.color.my_green))
                }
                1 -> {
                    openFragment(FragmentTwo.newInstance(), FragmentTwo.TAG)
                    heading_for_fragments.text = getString(R.string.green_fragment)
                    heading_for_fragments.setBackgroundResource(R.color.my_green)
                    button_next_fragment.setTextColor(getColor(R.color.my_blue))
                }
                2 -> {
                    openFragment(FragmentThree.newInstance(), FragmentThree.TAG)
                    heading_for_fragments.text = getString(R.string.blue_fragment)
                    heading_for_fragments.setBackgroundResource(R.color.my_blue)
                    button_next_fragment.setTextColor(getColor(R.color.my_red))
                }
            }
            i++
            if (i >= 3) i = 0
        }
    }

    private fun openFragment(fragment: Fragment, tag: String) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(tag)
            .add(R.id.place_holder_for_fragment, fragment)
            .commit()
    }
}