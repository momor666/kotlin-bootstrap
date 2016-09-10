package com.sbhachu.bootstrap.presentation.common

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.sbhachu.bootstrap.presentation.common.BasePresenter

abstract class BaseView<T : BasePresenter<*>> : LinearLayout {

    protected var presenter: T?

    init {
        presenter = initialisePresenter()
    }

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    protected fun initialise(layoutId: Int): Unit {
        val root: View? = LayoutInflater.from(context).inflate(layoutId, this)

        initialiseViews(root)
        initialiseListeners()
    }

    protected abstract fun initialisePresenter(): T
    protected abstract fun initialiseViews(view: View?): Unit
    protected abstract fun initialiseListeners(): Unit

    open fun onDestroy() {
        presenter?.dispose()
        presenter = null
    }


}