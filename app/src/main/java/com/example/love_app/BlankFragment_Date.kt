package com.example.love_app

import android.icu.util.Calendar
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.love_app.databinding.FragmentBlankDateBinding
import java.net.SocketImpl
import java.text.SimpleDateFormat
import java.util.Locale

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment_Date.newInstance] factory method to
 * create an instance of this fragment.
 */
class BlankFragment_Date : Fragment(R.layout.fragment_blank__date) {
    private lateinit var txt_hour:TextView
    private lateinit var txt_minimus:TextView
    private lateinit var txt_sec:TextView
    private lateinit var txt_date_in_heart_year:TextView
    private val handler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //cập nhật thời gian mỗi giây
        handler.post(object : Runnable {
            override fun run() {
                updateCurrentTime()
                handler.postDelayed(this, 1000)
            }
        })
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_blank__date,container,false)
        txt_hour = view.findViewById(R.id.txt_hour)
        txt_minimus = view.findViewById(R.id.txt_minmus)
        txt_sec = view.findViewById(R.id.txt_sec)
        txt_date_in_heart_year = view.findViewById(R.id.txt_date_in_heart_year)
        val bundle = arguments?:Bundle()
        val txt_days = bundle.getString("data")
        txt_date_in_heart_year.text = txt_days
        return view
    }
    //lấy thời gian hiên tại
    private fun updateCurrentTime() {
        val currentTime = System.currentTimeMillis()
        val hour = SimpleDateFormat("HH", Locale.getDefault())
        val minimus = SimpleDateFormat("mm",Locale.getDefault())
        val sec = SimpleDateFormat("ss",Locale.getDefault())
        val formattedTimeHour = hour.format(currentTime)
        val formattedTimeMinimus = minimus.format(currentTime)
        val formattedTimeSec =sec.format(currentTime)
        txt_hour.text = "$formattedTimeHour"
        txt_minimus.text = "$formattedTimeMinimus"
        txt_sec.text = "$formattedTimeSec"
    }
}