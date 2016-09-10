package com.sbhachu.bootstrap.extensions

import android.support.v4.view.ViewPager
import com.sbhachu.bootstrap.extensions.listener.PageWatcher

fun ViewPager.pageListener(init: PageWatcher.() -> Unit) {
    addOnPageChangeListener(PageWatcher().apply(init))
}