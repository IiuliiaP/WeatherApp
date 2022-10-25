package com.example.weatherapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.FragmentWeatherDetailsBinding
import com.example.weatherapp.viewModel.AppState

import com.example.weatherapp.viewModel.WeatherDetailsVewModel

class WeatherDetailsFragment : Fragment() {
    lateinit var binding : FragmentWeatherDetailsBinding
    lateinit var viewModel: WeatherDetailsVewModel

    companion object{
        fun newInstance() : Fragment {
            return  WeatherDetailsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherDetailsBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(WeatherDetailsVewModel ::class.java )
        viewModel.getLivaData().observe(viewLifecycleOwner, object : Observer<AppState>{
            override fun onChanged(t: AppState?) {
                if (t != null) {
                    renderData(t)
                }
            }
        })

        viewModel.sendRequest()
    }

    private fun renderData(appState: AppState){
        when(appState){
            is AppState.Loading -> TODO()
            is AppState.Error -> {

            }
            is AppState.Success -> {
                val result = appState.weatherData
                binding.cityName.text =  result.city.name
                binding.temperature.text = result.temperature.toString()
                binding.weatherInfo.text = result.feelsLike.toString()
            }
        }

    }

}

