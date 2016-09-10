package com.sbhachu.bootstrap.extensions

import android.widget.TextView
import com.sbhachu.bootstrap.extensions.listener.TextWatcher

fun TextView.textWatcher(init: TextWatcher.() -> Unit) {
    addTextChangedListener(TextWatcher().apply(init))
}

fun TextView.readOnly(readOnly: Boolean) {
    this.isEnabled = !readOnly
    this.isFocusable = !readOnly
    this.isFocusableInTouchMode = !readOnly
    this.isClickable = !readOnly
    this.isLongClickable = !readOnly
    this.isCursorVisible = !readOnly
}
