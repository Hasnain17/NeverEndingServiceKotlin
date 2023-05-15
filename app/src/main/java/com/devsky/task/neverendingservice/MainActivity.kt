package com.devsky.task.neverendingservice

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.devsky.task.neverendingservice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val tag: String = javaClass.simpleName
    private var binding: ActivityMainBinding? = null
    private val viewModel: MyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        initObservers()

        viewModel.startCounter()
    }
    private fun initObservers() {
        Log.i(tag, "registering Observers: ViewModel? $viewModel")
        viewModel.currentCounter.observe(this) { value ->
            Log.i(tag, "inserting value")
            binding?.value?.text = value.toString()
        }
    }
    private fun closeObservers() {
        Log.i(tag, "registering Observers: ViewModel? $viewModel")
        viewModel.currentCounter.removeObservers (this)
    }
}