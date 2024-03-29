package com.example.jessenjj_kotlin.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jessenjj_kotlin.adapter.MessageTabAdapter
import com.example.jessenjj_kotlin.base.BaseFragment
import com.example.jessenjj_kotlin.databinding.FragmentMessageBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MessageFragment : BaseFragment<FragmentMessageBinding>() {

    private var adapterMessage : MessageTabAdapter? = null

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentMessageBinding {
       return FragmentMessageBinding.inflate(inflater,container,false)
    }

    override fun setupView() {
        setupTabView()
    }

    private fun setupTabView(){
        val tabLayout = binding.tabMessage
        val viewPager = binding.vpMessage
        adapterMessage = MessageTabAdapter(this)
        adapterMessage?.addListFragment(NotificationFragment())
        adapterMessage?.addListFragment(HistoryFragment())
        viewPager.adapter = adapterMessage

        TabLayoutMediator(tabLayout,viewPager) {
            tab,position -> when(position){
                0 -> {
                    tab.text = "Notification"
                }
                1 -> {
                    tab.text = "History"
                }
            }
        }.attach()
    }


}