package com.example.jessenjj_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jessenjj_kotlin.databinding.ItemAccountBalanceBinding
import com.example.jessenjj_kotlin.databinding.ItemsListTransactionBinding
import com.example.jessenjj_kotlin.model.AccountNumberModel
import com.example.jessenjj_kotlin.model.TransactionInboxModel

class AccountBalanceAdapter(
    private var _data: List<AccountNumberModel>

) : RecyclerView.Adapter<AccountBalanceAdapter.AccountNumberViewHolder>(

){

    inner class AccountNumberViewHolder(
        val binding: ItemAccountBalanceBinding

    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:AccountNumberModel){
            binding.tvTipeTabungan.text = data.savingType
            binding.tvNomorRekening.text = data.numberRekening
            binding.tvNominalAccount.text = data.balanceAmount.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return AccountNumberViewHolder(
            ItemAccountBalanceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(_data[position])
    }
}
