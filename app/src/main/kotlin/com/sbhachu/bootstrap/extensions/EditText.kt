package com.sbhachu.bootstrap.extensions

import android.widget.EditText

fun EditText.getString() : String? {
    return text.toString()
}