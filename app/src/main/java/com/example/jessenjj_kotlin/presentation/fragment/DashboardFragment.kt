package com.example.jessenjj_kotlin.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.adapter.AccountBalanceAdapter
import com.example.jessenjj_kotlin.base.BaseFragment
import com.example.jessenjj_kotlin.databinding.FragmentAdminBinding
import com.example.jessenjj_kotlin.databinding.FragmentDashboardBinding
import com.example.jessenjj_kotlin.model.AccountNumberModel
import com.example.jessenjj_kotlin.model.MenuDashboardModel
import com.example.jessenjj_kotlin.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.jessenjj_kotlin.utils.HorizontalItemDecoration

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountBalanceAdapter

    private val horizontalItemDecoration by lazy{
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true
        )
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        setupViewMenu()
        setupViewAccountBalance()
    }

    private fun setupViewMenu(){
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context =  binding.root.context
        )
        binding.componentMenu.gvMenu.adapter = menuAdapter
        binding.componentMenu.gvMenu.onItemClickListener = AdapterView.OnItemClickListener{
                _,_, position, _ ->
            Toast.makeText(
                binding.root.context,
                populateDataMenu()[position].menuName,
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun setupViewAccountBalance(){
       accountAdapter = AccountBalanceAdapter(
            _data = populateDataAccount(),
        )
        binding.componentAccount.rvAccountRecycle.adapter = accountAdapter
        binding.componentAccount.rvAccountRecycle.layoutManager = LinearLayoutManager(
            binding.root.context,LinearLayoutManager.HORIZONTAL,false
        )
        binding.componentAccount.rvAccountRecycle.apply {
            if(itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun populateDataMenu(): List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.baseline_message_24,
                menuName = "Transfer",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_shopping_cart_24,
                menuName = "Pembelian",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_payment_24,
                menuName = "Pembayaran",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_payments_24,
                menuName = "Cardless",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_history_24,
                menuName = "History Pembayaran",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_currency_exchange_24,
                menuName = "Mutasi Rekening",
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_access_time_24,
                menuName = "Jadwal Sholat",
            ),

        )
    }

    private fun populateDataAccount(): List<AccountNumberModel>{
        return listOf(
            AccountNumberModel(
                savingType = "Tahapan Mudarabah",
                numberRekening = "02141005",
                balanceAmount = 458659743
            ),
            AccountNumberModel(
                savingType = "Tahapan Mudarabah2",
                numberRekening = "02141325",
                balanceAmount = 1242647653
            ),
            AccountNumberModel(
                savingType = "Tahapan Mudarabah3",
                numberRekening = "021410012",
                balanceAmount = 345746352
            ),

        )
    }


}