package com.sbhachu.bootstrap.extensions

import android.view.animation.Animation
import com.sbhachu.bootstrap.extensions.listener.AnimationListener

fun Animation.animationListener(init: AnimationListener.() -> Unit) {
    setAnimationListener(AnimationListener().apply(init))
}