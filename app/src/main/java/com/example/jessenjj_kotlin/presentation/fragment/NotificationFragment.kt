package com.example.jessenjj_kotlin.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jessenjj_kotlin.base.BaseFragment
import com.example.jessenjj_kotlin.databinding.FragmentNotificationBinding

class NotificationFragment : BaseFragment<FragmentNotificationBinding>(){
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater,container,false)
    }

    override fun setupView() {

    }
}