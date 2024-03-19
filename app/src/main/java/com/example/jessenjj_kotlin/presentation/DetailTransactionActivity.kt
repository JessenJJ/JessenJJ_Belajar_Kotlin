package com.example.jessenjj_kotlin.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.databinding.ActivityDetailTransactionBinding
import com.example.jessenjj_kotlin.databinding.ActivityRegisterBinding
import com.example.jessenjj_kotlin.model.TransactionModel
import com.example.jessenjj_kotlin.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)
        binding.tvTransferDate.text = transaction?.transferDate
        binding.tvTransferDestination.text = transaction?.transferDestination
        binding.tvTransferNominal.text = transaction?.transferAmount.toString()
        binding.tvTransferStatus.text = transaction?.transferStatus
        binding.tvTransferType.text = transaction?.transferType

    }




}