package com.redeyesncode.secondspicker

import android.app.Dialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import com.redeyesncode.secondspicker.databinding.SecondsPickerDialogBinding

class SecondsPickerDialog(context: Context,is24HourFormat:Boolean,numberPickerListeners: NumberPickerListeners) {

    lateinit var dialog: Dialog
    lateinit var binding:SecondsPickerDialogBinding
    var is24HourFormatLocal = is24HourFormat
    var listener = numberPickerListeners


    init {
        dialog = Dialog(context, R.style.RoundedCornersDialog)
        dialog.setCancelable(true)
        binding = SecondsPickerDialogBinding.inflate(LayoutInflater.from(context))

        dialog.setContentView(binding.root)
    }

    fun showDialog(){
        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.MATCH_PARENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT
        dialog.window!!.attributes = lp
        setupNumberPickers()
        dialog.show()

        binding.btnCancel.setOnClickListener {
            dialog.dismiss()
        }
        // by default am is check.
        binding.rbtnAM.isChecked = true

        // Setting 4:44:44 by default
        binding.npMinutes.value = 44
        binding.npHour.value = 4
        binding.npSeconds.value = 44
        binding.btnOk.setOnClickListener {
            val hour = binding.npHour.value
            val minutes = binding.npMinutes.value
            val seconds = binding.npSeconds.value
            val isAm = binding.rbtnAM.isChecked
            listener.onSelectTime(hour,minutes,seconds,isAm)
            dialog.dismiss()

        }


    }
    interface NumberPickerListeners{

        fun onSelectTime(hour:Int,minute:Int,seconds:Int,isAmChecked:Boolean)

    }

    private fun setupNumberPickers(){
        binding.npSeconds.minValue = 0
        binding.npSeconds.maxValue = 60
        binding.npMinutes.maxValue = 60
        binding.npMinutes.minValue = 0
        if(is24HourFormatLocal){
            // Show the 24 Hour Ui
            binding.npHour.minValue =0
            binding.npHour.maxValue=24
            binding.rbtnGrp.visibility = View.GONE

        }else{
            // Show the 12 Hour format ui.
            binding.npHour.minValue =0
            binding.npHour.maxValue=12
            binding.rbtnGrp.visibility = View.VISIBLE
        }




    }



}