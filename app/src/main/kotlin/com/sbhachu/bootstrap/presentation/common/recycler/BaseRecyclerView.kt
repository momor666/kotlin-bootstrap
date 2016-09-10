package com.sbhachu.bootstrap.presentation.common.recycler


import android.support.v7.widget.RecyclerView
import android.view.View

class BaseRecyclerView<V : View> : RecyclerView.ViewHolder {

    private var view: V? = null

    constructor(itemView: V?) : super(itemView) {
        this.view = view
    }

    public fun getView(): V? {
        return view
    }
}