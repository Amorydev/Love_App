package com.example.love_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.love_app.databinding.LayoutViewMomentsBinding

class RvAddMoments(val ds:List<OutData>):RecyclerView.Adapter<RvAddMoments.AnhViewHolder>() {
    inner class AnhViewHolder(private val binding:LayoutViewMomentsBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(data:OutData){
            binding.imgImagesMoments.setImageResource(data.images)
            binding.txtTitle.text = data.title
            binding.txtDateSetUp.text = data.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnhViewHolder {
        val binding = LayoutViewMomentsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return AnhViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnhViewHolder, position: Int) {
        holder.bind(ds[position])
    }

    override fun getItemCount(): Int {
        return ds.size
    }
}