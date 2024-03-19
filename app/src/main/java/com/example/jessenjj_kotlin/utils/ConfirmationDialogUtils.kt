package com.example.jessenjj_kotlin.utils

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.databinding.DialogueLayoutBinding

class ConfirmationDialogueUtils(private val context: Context) {

    fun showConfirmationDialogue(
        title: String,
        icon:Int? = null,
        onConfirm: () ->Unit,
        onCancel:() ->Unit,
    ){
        val  dialogueBuilder = AlertDialog.Builder(context)
        val alertDialogue = dialogueBuilder.create()

        val dialogView = LayoutInflater.from(context).inflate(R.layout.dialogue_layout,null)
        val binding = DialogueLayoutBinding.bind(dialogView)

        binding.tvTitle.text = title
        if(icon != null){
            binding.ivIconDialog.visibility = View.VISIBLE
            binding.ivIconDialog.setImageResource(icon)
        }else{
            binding.ivIconDialog.visibility = View.GONE

        }

        alertDialogue.setView(dialogView)

        binding.bYes.setOnClickListener {
            onConfirm.invoke()
            alertDialogue.dismiss()
        }
        binding.bNo.setOnClickListener {
            onCancel.invoke()
            alertDialogue.dismiss()
        }
        alertDialogue.show()

    }

}