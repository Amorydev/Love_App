package com.example.love_app

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.scwang.wave.MultiWaveHeader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startWaveWay(this)
    }

    private fun startWaveWay(context: Context) {
        val waveHeader = findViewById<MultiWaveHeader>(R.id.waveHeader)
        waveHeader.startColor = ContextCompat.getColor(context ,R.color.anamistar)
        waveHeader.closeColor = ContextCompat.getColor(context, R.color.endAnamistar)
    }


}
