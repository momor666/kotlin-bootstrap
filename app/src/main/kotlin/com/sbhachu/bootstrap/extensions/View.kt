package com.sbhachu.bootstrap.extensions

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View?.hideSoftKeyboard() {
    val inputMethodManager: InputMethodManager = this?.context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(this?.windowToken, 0)
}

fun View.hideSoftKeyboard(delayMs: Long) {
    val handler = Handler(Looper.getMainLooper())
    handler.postDelayed({ hideSoftKeyboard() }, delayMs)
}