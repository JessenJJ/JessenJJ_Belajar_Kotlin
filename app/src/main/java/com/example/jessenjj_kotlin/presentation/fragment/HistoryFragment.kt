package com.example.jessenjj_kotlin.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.jessenjj_kotlin.base.BaseFragment
import com.example.jessenjj_kotlin.databinding.FragmentHistoryBinding
import com.example.jessenjj_kotlin.databinding.FragmentMessageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHistoryBinding {

        return FragmentHistoryBinding.inflate(inflater,container, false )
    }

    override fun setupView() {

    }

}