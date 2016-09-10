package com.sbhachu.bootstrap.presentation.common

import com.sbhachu.bootstrap.presentation.common.IViewContract
import java.lang.ref.WeakReference

abstract class BasePresenter<V : IViewContract>(view: V) {

    private var viewReference: WeakReference<V> = WeakReference(view)

    fun getView(): V? {
        return viewReference.get()
    }

    fun dispose() : Unit {
        viewReference.clear()
    }
}
