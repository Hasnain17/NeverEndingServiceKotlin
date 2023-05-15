package com.devsky.task.neverendingservice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.work.Constraints
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkManager

class RestarterBroadcastReceiver : BroadcastReceiver() {
    private val tag : String = javaClass.simpleName
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(tag, "received!")
        startWorker(context)
    }

    companion object {
        fun startWorker(context: Context) {
            val constraints = Constraints.Builder()
                .build()
            val request = OneTimeWorkRequestBuilder<MainCoroutineWorker>()
                .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
                .setConstraints(constraints)
                .build()
            Log.d("TAG", "starting!")
            WorkManager.getInstance(context)
                .enqueue(request)
        }
    }
}

