package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.view.WeatherDetailsFragment

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if(savedInstanceState == null){
            supportFragmentManager.beginTransaction().replace(R.id.fragment_container, WeatherDetailsFragment.newInstance()).commit()
        }
    }
}


