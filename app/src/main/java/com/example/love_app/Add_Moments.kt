package com.example.love_app

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.love_app.databinding.ActivityAddMomentsBinding
import com.example.love_app.databinding.ActivityAddPickerMomentsBinding


private lateinit var binding: ActivityAddMomentsBinding
private lateinit var binding2:ActivityAddPickerMomentsBinding
class Add_Moments : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMomentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        onBack()
        onAdd()
    }

    private fun onAdd() {
        binding.imbAdd.setOnClickListener {
            intent = Intent(this, AddPickerMoments::class.java)
            startActivity(intent)

        }
    }

    private fun onBack() {
        binding.btnBack.setOnClickListener {
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}