package com.example.weatherapp.view

import android.icu.lang.UCharacter.GraphemeClusterBreak.L
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.R
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.viewmodel.AppState
import com.example.weatherapp.viewmodel.MainViewModel

class MainFragment: Fragment() {

    private var _binding: FragmentMainBinding? = null
    val binding: FragmentMainBinding
    get(){
        return _binding!!
    }

    private lateinit var viewModel: MainViewModel

    companion object{
        fun newInstance()= MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_main, container, false)
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer<AppState>{
            renderData(it)
//            Toast.makeText(context, "simple text", Toast.LENGTH_LONG).show()
        })
        viewModel.getDataFromRemoteSource()
    }

    fun renderData(appState: AppState){
        when(appState){
            is AppState.Error -> TODO()
            AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
                binding.message.text = ""
            }
            is AppState.Success -> {
                binding.loadingLayout.visibility = View.GONE
                binding.message.text = "OK"
            }

        }

    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}