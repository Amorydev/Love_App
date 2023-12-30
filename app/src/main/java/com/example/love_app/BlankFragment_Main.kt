package com.example.love_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment_Main.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment_Main : Fragment(R.layout.fragment_blank__main) {
    private lateinit var txt_hur:TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank__main, container, false)
        txt_hur = view.findViewById(R.id.textcountdate)
        val bundle = arguments
        if (bundle == null) {

        }
        return view
    }


}