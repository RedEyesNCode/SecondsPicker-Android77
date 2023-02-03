package com.redeyesncode.secondspicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.redeyesncode.secondspicker.databinding.ActivitySecondPickerBinding

class SecondPickerActivity : AppCompatActivity(), SecondsPickerDialog.NumberPickerListeners {

    private lateinit var binding:ActivitySecondPickerBinding

    override fun onSelectTime(hour: Int, minute: Int, seconds: Int, isAmChecked: Boolean) {
        Snackbar.make(binding.root,"$hour : $minute : $seconds is selected time.",Snackbar.LENGTH_SHORT)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.btnPickSeconds.setOnClickListener {
            var secondsPickerDialog = SecondsPickerDialog(this,false,this)
            secondsPickerDialog.showDialog()

        }




        setContentView(R.layout.activity_second_picker)
    }
}