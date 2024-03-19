package com.example.jessenjj_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jessenjj_kotlin.databinding.ItemsListTransactionBinding
import com.example.jessenjj_kotlin.model.TransactionModel


class ListTransactionAdapter :
    RecyclerView.Adapter<ListTransactionAdapter.TransactionViewHolder>(){

        private var _onClickTransaction: (TransactionModel) -> Unit = {}

        private var _data: MutableList<TransactionModel> = mutableListOf()

    fun setData(newData: MutableList<TransactionModel>){
        _data = newData
        notifyDataSetChanged()
    }

    fun setOnClickTransaction(Listener:(TransactionModel)-> Unit) {
        _onClickTransaction = Listener
    }

    inner class TransactionViewHolder(private val binding: ItemsListTransactionBinding)
        : RecyclerView.ViewHolder(binding.root)
    {
        fun bind(item: TransactionModel, onClickTransaction: (TransactionModel) -> Unit){
            binding.tvTransferType.text = item.transferType
            binding.tvTransferDestination.text = item.transferDestination
            binding.tvTransferDate.text = item.transferDate
            binding.tvTransferStatus.text = item.transferStatus
            binding.tvTransferNominal.text = item.transferAmount.toString()

            binding.root.setOnClickListener{ onClickTransaction.invoke(item) }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(ItemsListTransactionBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )
    }

    override fun getItemCount(): Int {
        return _data.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        holder.bind(_data[position],_onClickTransaction)
    }

}