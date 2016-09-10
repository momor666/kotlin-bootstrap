package com.sbhachu.bootstrap.extensions

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

fun broadcastReceiver(init: (Context, Intent?) -> Unit): BroadcastReceiver {
    return object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent?) {
            init(context, intent)
        }
    }
}