package com.redeyesncode.secondspickerandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.redeyesncode.secondspicker.SecondsPickerDialog
import com.redeyesncode.secondspickerandroid.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),SecondsPickerDialog.NumberPickerListeners {

    private lateinit var binding:ActivityMainBinding

    override fun onSelectTime(hour: Int, minute: Int, seconds: Int, isAmChecked: Boolean) {
        Snackbar.make(binding.root,"$hour : $minute : $seconds is selected time.", Snackbar.LENGTH_SHORT)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.secondsPicker.setOnClickListener {

            var secondsPickerDialog = SecondsPickerDialog(this,false,this)
            secondsPickerDialog.showDialog()

        }
        setContentView(binding.root)
    }


}