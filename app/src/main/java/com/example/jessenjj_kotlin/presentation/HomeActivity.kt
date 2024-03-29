package com.example.jessenjj_kotlin.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.databinding.ActivityHomeBinding
import com.example.jessenjj_kotlin.presentation.fragment.AdminFragment
import com.example.jessenjj_kotlin.presentation.fragment.DashboardFragment
import com.example.jessenjj_kotlin.presentation.fragment.InboxFragment
import com.example.jessenjj_kotlin.presentation.fragment.MessageFragment
import com.example.jessenjj_kotlin.utils.ConfirmationDialogueUtils
import com.example.jessenjj_kotlin.utils.SharePrefHelper
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    private lateinit var confirmationDialogueUtils: ConfirmationDialogueUtils


    private lateinit var sharePref: SharePrefHelper

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigationHome -> {
                    replaceFragment(DashboardFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationInbox -> {
                    replaceFragment(InboxFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationAdmin -> {
                    replaceFragment(AdminFragment())
                    return@OnNavigationItemSelectedListener true
                }

                R.id.navigationMessage -> {
                    replaceFragment(MessageFragment())
                    return@OnNavigationItemSelectedListener false
                }

                R.id.navigationLogout -> {
                    showConfirmation()
                    return@OnNavigationItemSelectedListener false
                }

            }; false

        }


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharePref = SharePrefHelper(this)

        confirmationDialogueUtils = ConfirmationDialogueUtils(this)

        binding.bottomNavigation.setOnNavigationItemSelectedListener(
            onNavigationItemSelectedListener
        )

        if (savedInstanceState == null) {
            binding.bottomNavigation.selectedItemId = R.id.navigationHome
        }

    }

    private fun showConfirmation() {
        val title = "Are you sure you want to quit?"
        val icon = androidx.appcompat.R.drawable.abc_ic_menu_cut_mtrl_alpha

        confirmationDialogueUtils.showConfirmationDialogue(
            title = title, icon = icon,
            onConfirm = {
                sharePref.clearDataPref()
                finish()
            },
            onCancel = {

            }

        )

    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}