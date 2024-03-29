package com.example.jessenjj_kotlin.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.adapter.AccountBalanceAdapter
import com.example.jessenjj_kotlin.adapter.PromoMenuAdapter
import com.example.jessenjj_kotlin.base.BaseFragment
import com.example.jessenjj_kotlin.databinding.FragmentDashboardBinding
import com.example.jessenjj_kotlin.model.AccountNumberModel
import com.example.jessenjj_kotlin.model.MenuDashboard
import com.example.jessenjj_kotlin.model.PromoModel
import com.example.jessenjj_kotlin.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.jessenjj_kotlin.presentation.viewmodel.DashboardViewModel
import com.example.jessenjj_kotlin.utils.HorizontalItemDecoration
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel: DashboardViewModel by viewModels()

    private lateinit var menuAdapter: DashboardMenuAdapter
    private lateinit var accountAdapter: AccountBalanceAdapter
    private lateinit var promosAdapter: PromoMenuAdapter

    private val horizontalItemDecoration by lazy {
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

        viewModel.getAccountMenu()
        viewModel.getPromoMenu()
        viewModel.getHomeMenu()

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.homeMenu.observe(viewLifecycleOwner) {
            setupViewMenu(it.data)
        }
        viewModel.homeAccount.observe(viewLifecycleOwner) {
            setupViewAccountBalance(it)
        }
        viewModel.homePromo.observe(viewLifecycleOwner) {
            setupViewPromo(it)
        }

    }

    private fun setupViewMenu(data: List<MenuDashboard>?) {
//        if (!data.isNullOrEmpty().not()) {
//
//        } else {
//
//        }

        menuAdapter = DashboardMenuAdapter(
            menuData = data ?: listOf(),
            context = binding.root.context
        )

        binding.componentMenu.gvMenu.adapter = menuAdapter
        binding.componentMenu.gvMenu.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                Toast.makeText(
                    binding.root.context,
                    data?.get(position)?.nameMenu,
                    Toast.LENGTH_SHORT
                ).show()
            }

        //        binding.editText.addOntextChangeLsitener{
//            val keyword = binding.editText.text.toString()
//            viewModel.getHomeMenu(keyword)
//        }
    }



    private fun setupViewAccountBalance(data: List<AccountNumberModel>) {
        accountAdapter = AccountBalanceAdapter(
            _data = data,
        )
        binding.componentAccount.rvAccountRecycle.adapter = accountAdapter
        binding.componentAccount.rvAccountRecycle.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentAccount.rvAccountRecycle.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun setupViewPromo(data: List<PromoModel>) {
        promosAdapter = PromoMenuAdapter(
            _data = data,
        )
        binding.componentPromo.rvPromoRecycle.adapter = promosAdapter
        binding.componentPromo.rvPromoRecycle.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL, false
        )
        binding.componentPromo.rvPromoRecycle.apply {
            if (itemDecorationCount <= 0) {
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }


}