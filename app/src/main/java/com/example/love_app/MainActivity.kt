package com.example.love_app

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.love_app.databinding.ActivityMainBinding
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.tabs.TabLayoutMediator
import com.scwang.wave.MultiWaveHeader

private lateinit var binding: ActivityMainBinding
private lateinit var intent: Intent

open class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        startWaveWay(this)
        binding.btnChangeImageMale.setOnClickListener {
            selectImageAvatar(1)
        }
        binding.btnChangeImageFemale.setOnClickListener {
            selectImageAvatar(2)
        }
        onCLickMoments()
        onClickTabView()
    }

    private fun onClickTabView() {
        val adapter = ViewAdapter(supportFragmentManager,lifecycle)
        binding.vplayout.adapter = adapter
        TabLayoutMediator(binding.pageIndicator, binding.vplayout){
                tab,position ->
        }.attach()
    }

    private fun onCLickMoments() {
        binding.imbGallery.setOnClickListener {
            intent = Intent(this, Add_Moments::class.java)
            startActivity(intent)
        }
    }

    private fun selectImageAvatar(avatarid: Int) {
        ImagePicker.with(this)
            //cắt ảnh
            .crop()
            //kích thước hình ảnh cuối cùng
            .compress(1024)
            //độ phân giải của ảnh
            .maxResultSize(1080, 1080)
            .start(avatarid)
    }

    private var uriAvatarMale: Uri? = null
    private var uriAvatarFeMale: Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        //kiểm tra xem kết quả trả về thành công hay không
        if (resultCode == Activity.RESULT_OK) {
            // khởi tạo đối tượng uri từ Intent dẫn đến hình ảnh
            when (requestCode) {
                1 -> {
                    uriAvatarMale = data?.data!!
                }

                2 -> {
                    uriAvatarFeMale = data?.data!!
                }
            }

        } else if (resultCode == ImagePicker.RESULT_ERROR) {
            //Nêú thư viện picker có lỗi xảy ra thì thông báo lỗi
            Toast.makeText(this, ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Không thể thực hiện", Toast.LENGTH_SHORT).show()
        }
        when (requestCode) {
            1 -> {
                binding.avtmale.setImageURI(uriAvatarMale)
            }

            2 -> {
                binding.avtfemale.setImageURI(uriAvatarFeMale)
            }
        }
    }


    private fun startWaveWay(context: Context) {
        val waveHeader = findViewById<MultiWaveHeader>(R.id.waveHeader)
        waveHeader.startColor = ContextCompat.getColor(context, R.color.anamistar)
        waveHeader.closeColor = ContextCompat.getColor(context, R.color.endAnamistar)
    }


}
