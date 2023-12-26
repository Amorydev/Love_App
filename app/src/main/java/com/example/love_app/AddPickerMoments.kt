package com.example.love_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.love_app.databinding.ActivityAddPickerMomentsBinding
import com.github.dhaval2404.imagepicker.ImagePicker

private lateinit var binding:ActivityAddPickerMomentsBinding
class AddPickerMoments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPickerMomentsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onCLickAddPicker()
        onBack()
    }

    private fun onBack() {
        binding.imbBackAddMoments.setOnClickListener {
            intent = Intent(this,Add_Moments::class.java)
            startActivity(intent)
        }
    }

    private fun onCLickAddPicker() {
        binding.addPickerMoments.setOnClickListener {
            selectImageAvatar()
        }
    }
    private fun selectImageAvatar() {
        ImagePicker.with(this)
            //kích thước hình ảnh cuối cùng
            .compress(1024)
            //độ phân giải của ảnh
            .maxResultSize(1080, 1080)
            .start()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == RESULT_OK) {
            val uri: Uri = data?.data!!
            binding.addPickerMoments.setImageURI(uri)
        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Không thể thực hiện", Toast.LENGTH_SHORT).show()
        }
    }
}