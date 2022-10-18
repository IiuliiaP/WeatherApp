package com.example.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.weatherapp.R
import com.example.weatherapp.databinding.FragmentWeatherInfoBinding
import com.example.weatherapp.viewModel.WeatherInfoVewModel

class WeatherInfoFragment : Fragment() {
    lateinit var binding : FragmentWeatherInfoBinding
    lateinit var vewModel: WeatherInfoVewModel

    companion object{
        fun newInstance() = WeatherInfoFragment
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherInfoBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vewModel = ViewModelProvider(this).get(WeatherInfoVewModel ::class.java )
        vewModel.liveData.observe(viewLifecycleOwner, Observer { Toast.makeText(requireContext(),"Message", Toast.LENGTH_SHORT).show() })
    }



    }

