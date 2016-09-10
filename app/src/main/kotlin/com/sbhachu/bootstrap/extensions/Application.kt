package com.sbhachu.bootstrap.extensions

import android.app.Application
import com.sbhachu.bootstrap.extensions.listener.ApplicationLifecycleCallbacks

fun Application.addLifecycleCallbacks(init: ApplicationLifecycleCallbacks.() -> Unit) {
    registerActivityLifecycleCallbacks(ApplicationLifecycleCallbacks().apply(init))
}