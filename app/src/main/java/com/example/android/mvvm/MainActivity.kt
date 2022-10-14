package com.example.android.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android.mvvm.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var randomNumberViewModel : RandomNumberViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, GroceryViewModelFactory(application))[MainViewModel::class.java]
        randomNumberViewModel = ViewModelProvider(this)[RandomNumberViewModel::class.java]

        binding.btnAddNote.setOnClickListener {
            viewModel.addNote(Note(content = "New note"))
        }

        binding.btnRandomString.setOnClickListener {
            randomNumberViewModel.getStringRandom()
        }

        binding.btnRandomInt.setOnClickListener {
            randomNumberViewModel.getIntRandom()
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.notesLiveData?.observe(this){
            it?.let {
                it.forEach {
                    Log.d("thinhvh", "Note id = ${it.id}")
                }
            }
        }

        randomNumberViewModel.stringRandomLiveData.observe(this){
            Log.d("thinhvh", "Random String = ${it}")
        }

        randomNumberViewModel.intRandomLiveData.observe(this){
            Log.d("thinhvh", "Random Int = ${it}")
        }

        randomNumberViewModel.intAndStringRandomLiveData.observe(this){
            Log.d("thinhvh", "intAndStringRandomLiveData = ${it}")
        }

    }

    class GroceryViewModelFactory(private val application: android.app.Application):ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(application) as T
        }
    }
}