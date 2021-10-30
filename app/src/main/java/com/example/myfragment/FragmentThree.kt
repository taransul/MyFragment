package com.example.myfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_three.*

class FragmentThree : Fragment() {

    companion object {
        const val TAG = "FirstFragment"

        fun newInstance() = FragmentThree()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_three, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button3.setOnClickListener {
            text_fragment_3.text = getString(R.string.hello)
        }
    }
}