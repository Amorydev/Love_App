package com.example.love_app

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.ContextMenu
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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
    private lateinit var imb_heart:ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_blank__main, container, false)
        imb_heart = view.findViewById(R.id.imb_heart)
        txt_hur = view.findViewById(R.id.textcountdate)
        registerForContextMenu(imb_heart)
        return view
    }

    override fun onCreateContextMenu(
        menu: ContextMenu,
        v: View,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu.add(3,1,1,"Change date")
    }


}