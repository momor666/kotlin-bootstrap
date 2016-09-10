package com.sbhachu.bootstrap.presentation.common

import android.annotation.TargetApi
import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sbhachu.bootstrap.presentation.common.BasePresenter


abstract class BaseFragment<T : BasePresenter<*>> : Fragment() {

    protected abstract var layoutId: Int

    protected var presenter: T?

    init {
        presenter = initialisePresenter()
    }

    protected abstract fun initialisePresenter(): T
    protected abstract fun initialiseViews(view: View?): Unit
    protected abstract fun initialiseListeners(): Unit
    protected abstract fun handleArguments(bundle: Bundle?): Unit
    protected abstract fun onAttachToContext(context: Context?): Unit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        handleArguments(arguments)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root: View? = inflater?.inflate(layoutId, container, false)
        initialiseViews(root)
        initialiseListeners()
        return root
    }

    @TargetApi(23)
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        onAttachToContext(context)
    }

    @Suppress("OverridingDeprecatedMember", "DEPRECATION")
    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            onAttachToContext(activity)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.dispose()
    }
}