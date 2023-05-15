package com.devsky.task.neverendingservice


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData


class MyViewModel(@get:JvmName("getAdapterContext")private val application: Application) : AndroidViewModel(application) {
    var currentCounter: MutableLiveData<Int> = CounterService.counter

    fun startCounter() {
        RestarterBroadcastReceiver.startWorker(application)
    }

}
