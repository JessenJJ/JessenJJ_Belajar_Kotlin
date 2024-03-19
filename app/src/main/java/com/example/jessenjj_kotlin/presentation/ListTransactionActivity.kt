package com.example.jessenjj_kotlin.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jessenjj_kotlin.adapter.ListTransactionAdapter
import com.example.jessenjj_kotlin.databinding.ActivityListTransactionBinding
import com.example.jessenjj_kotlin.databinding.ActivityLoginBinding
import com.example.jessenjj_kotlin.model.TransactionModel

class ListTransactionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListTransactionBinding

    private var listtransactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvListTransaction.adapter = listtransactionAdapter
        listtransactionAdapter.setData(createDummyListTransaction())
        listtransactionAdapter.setOnClickTransaction { transaction ->
           navigateToDetailTransaction(transaction)
        }


    }

    private fun navigateToDetailTransaction(data:TransactionModel) {
        val intent = Intent(this,DetailTransactionActivity::class.java)
    }

        private fun createDummyListTransaction() : MutableList<TransactionModel>{
            return mutableListOf(
                TransactionModel(
                    transferType = "QRIS Mandiri",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "13/3/2024",
                    transferStatus = "Success",
                    transferAmount = 200000000000.0
                ),
                TransactionModel(
                    transferType = "QRIS BCA",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "5/3/2024",
                    transferStatus = "Success",
                    transferAmount = 500000000000.0
                ),
                TransactionModel(
                    transferType = "QRIS Mega",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "13/3/2024",
                    transferStatus = "Success",
                    transferAmount = 200000000000.0
                ),
                TransactionModel(
                    transferType = "Transfer BCA",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "5/3/2024",
                    transferStatus = "Success",
                    transferAmount = 500000000000.0
                ),
                TransactionModel(
                    transferType = "Transfer Mandiri",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "13/3/2024",
                    transferStatus = "Success",
                    transferAmount = 200000000000.0
                ),
                TransactionModel(
                    transferType = "Transfer MEGA",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "5/3/2024",
                    transferStatus = "Success",
                    transferAmount = 500000000000.0
                ),
                TransactionModel(
                    transferType = "Transfer Bukopin",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "13/3/2024",
                    transferStatus = "Success",
                    transferAmount = 200000000000.0
                ),
                TransactionModel(
                    transferType = "QRIS Bukopin",
                    transferDestination = "Tuan Rumah Jessen",
                    transferDate = "5/3/2024",
                    transferStatus = "Success",
                    transferAmount = 500000000000.0
                ),

            )
        }

    companion object {
        const val TRANSACTION_KEY = "transaction_key"
    }

}