package com.example.love_app

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.findFragment

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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank__main, container, false)
        /*var imb_heart = view.findViewById<Button>(R.id.imb_heart)*/
        var txt_hur = view.findViewById<TextView>(R.id.textcountdate)
        val bundle = arguments?:Bundle()
        val txt = bundle.getString("key",0.toString())
        txt_hur.text = txt

        return view
    }
}