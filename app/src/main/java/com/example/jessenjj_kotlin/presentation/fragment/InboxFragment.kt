package com.example.jessenjj_kotlin.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.jessenjj_kotlin.adapter.ListTransactionAdapter
import com.example.jessenjj_kotlin.adapter.ListTransactionInboxAdapter
import com.example.jessenjj_kotlin.databinding.FragmentAdminBinding
import com.example.jessenjj_kotlin.databinding.FragmentDashboardBinding
import com.example.jessenjj_kotlin.databinding.FragmentInboxBinding
import com.example.jessenjj_kotlin.model.TransactionInboxModel


class InboxFragment : Fragment(){
    private var _binding: FragmentInboxBinding? = null
    private val binding get() = _binding!!

    private var listtransactionAdapter = ListTransactionInboxAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInboxBinding.inflate(inflater,container,false)
        binding.rvListTransactionInbox.adapter = listtransactionAdapter
        listtransactionAdapter.setData(createDummyListTransaction())
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun createDummyListTransaction() : MutableList<TransactionInboxModel>{
        return mutableListOf(
            TransactionInboxModel(
                transferType = "QRIS Mandiri",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "13/3/2024",
                transferStatus = "Success",
                transferAmount = 200000000000.0
            ),
            TransactionInboxModel(
                transferType = "QRIS BCA",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "5/3/2024",
                transferStatus = "Success",
                transferAmount = 500000000000.0
            ),
            TransactionInboxModel(
                transferType = "QRIS Mega",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "13/3/2024",
                transferStatus = "Success",
                transferAmount = 200000000000.0
            ),
            TransactionInboxModel(
                transferType = "Transfer BCA",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "5/3/2024",
                transferStatus = "Success",
                transferAmount = 500000000000.0
            ),
            TransactionInboxModel(
                transferType = "Transfer Mandiri",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "13/3/2024",
                transferStatus = "Success",
                transferAmount = 200000000000.0
            ),
            TransactionInboxModel(
                transferType = "Transfer MEGA",
                transferDestination = "Tuan Rumah Jessen",
                transferDate = "5/3/2024",
                transferStatus = "Success",
                transferAmount = 500000000000.0
            ),

            )
    }

}