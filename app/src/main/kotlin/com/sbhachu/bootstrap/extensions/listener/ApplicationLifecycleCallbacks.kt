package com.sbhachu.bootstrap.extensions.listener

import android.app.Activity
import android.app.Application
import android.os.Bundle

open class ApplicationLifecycleCallbacks : Application.ActivityLifecycleCallbacks {

    private var _onActivityPaused: ((activity: Activity?) -> Unit)? = null
    private var _onActivityStarted: ((activity: Activity?) -> Unit)? = null
    private var _onActivityDestroyed: ((activity: Activity?) -> Unit)? = null
    private var _onActivitySaveInstanceState: ((activity: Activity?, bundle: Bundle?) -> Unit)? = null
    private var _onActivityStopped: ((activity: Activity?) -> Unit)? = null
    private var _onActivityCreated: ((activity: Activity?, bundle: Bundle?) -> Unit)? = null
    private var _onActivityResumed: ((activity: Activity?) -> Unit)? = null

    override fun onActivityPaused(activity: Activity?) {
        _onActivityPaused?.invoke(activity)
    }

    override fun onActivityStarted(activity: Activity?) {
        _onActivityStarted?.invoke(activity)
    }

    override fun onActivityDestroyed(activity: Activity?) {
        _onActivityDestroyed?.invoke(activity)
    }

    override fun onActivitySaveInstanceState(activity: Activity?, bundle: Bundle?) {
        _onActivitySaveInstanceState?.invoke(activity, bundle)
    }

    override fun onActivityStopped(activity: Activity?) {
        _onActivityStopped?.invoke(activity)
    }

    override fun onActivityCreated(activity: Activity?, bundle: Bundle?) {
        _onActivityCreated?.invoke(activity, bundle)
    }

    override fun onActivityResumed(activity: Activity?) {
        _onActivityResumed?.invoke(activity)
    }

    fun onActivityPaused(listener: (Activity?) -> Unit) {
        _onActivityPaused = listener
    }

    fun onActivityStarted(listener: (Activity?) -> Unit) {
        _onActivityStarted = listener
    }

    fun onActivityDestroyed(listener: (Activity?) -> Unit) {
        _onActivityDestroyed = listener
    }

    fun onActivitySaveInstanceState(listener: (Activity?, Bundle?) -> Unit) {
        _onActivitySaveInstanceState = listener
    }

    fun onActivityStopped(listener: (Activity?) -> Unit) {
        _onActivityStopped = listener
    }

    fun onActivityCreated(listener: (Activity?, Bundle?) -> Unit) {
        _onActivityCreated = listener
    }

    fun onActivityResumed(listener: (Activity?) -> Unit) {
        _onActivityResumed = listener
    }
}