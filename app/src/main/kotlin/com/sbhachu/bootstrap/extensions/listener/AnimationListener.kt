package com.sbhachu.bootstrap.extensions.listener

import android.view.animation.Animation

class AnimationListener : Animation.AnimationListener {

    private var _onAnimationStart: ((animation: Animation) -> Unit)? = null
    private var _onAnimationEnd: ((animation: Animation) -> Unit)? = null
    private var _onAnimationRepeat: ((animation: Animation) -> Unit)? = null

    override fun onAnimationStart(animation: Animation) {
        _onAnimationStart?.invoke(animation)
    }

    override fun onAnimationEnd(animation: Animation) {
        _onAnimationEnd?.invoke(animation)
    }

    override fun onAnimationRepeat(animation: Animation) {
        _onAnimationRepeat?.invoke(animation)
    }

    fun onAnimationStart(listener: (Animation?) -> Unit) {
        _onAnimationStart = listener
    }

    fun onAnimationEnd(listener: (Animation?) -> Unit) {
        _onAnimationEnd = listener
    }

    fun onAnimationRepeat(listener: (Animation?) -> Unit) {
        _onAnimationRepeat = listener
    }
}