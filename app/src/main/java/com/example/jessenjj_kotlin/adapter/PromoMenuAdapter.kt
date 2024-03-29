package com.example.jessenjj_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jessenjj_kotlin.databinding.ItemPromoBinding

import com.example.jessenjj_kotlin.model.PromoModel


class PromoMenuAdapter(
    private var _data: List<PromoModel>

) : RecyclerView.Adapter<PromoMenuAdapter.PromoViewHolder>(

){

    inner class PromoViewHolder(
        val binding: ItemPromoBinding

    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:PromoModel){
            binding.ivPromo.setImageResource(data.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PromoViewHolder {
        return PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: PromoViewHolder, position: Int) {
        holder.bind(_data[position])
    }
}
