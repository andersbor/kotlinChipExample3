package com.example.chipexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.chipexample.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view: View = binding.root
        setContentView(view)

        binding.coffeeChip.setOnClickListener {
            binding.textViewMessage.text = "Clicked"
        }

        binding.coffeeChip.setOnCheckedChangeListener { compoundButton, checked ->
            binding.textViewMessage.text = checked.toString()
        }

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            // https://howtodoandroid.com/android-chips-material-component/
            val chip: Chip = group.findViewById(checkedIds[0])
            binding.textViewMessage.text = "You want " + chip.text
        }
    }
}