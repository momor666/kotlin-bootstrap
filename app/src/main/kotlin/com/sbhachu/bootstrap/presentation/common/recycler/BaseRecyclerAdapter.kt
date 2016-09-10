package com.sbhachu.bootstrap.presentation.common.recycler


import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import java.util.*

abstract class BaseRecyclerAdapter<T, V : View>() : RecyclerView.Adapter<BaseRecyclerView<V>>() {

    private var listener : ItemListener<T>? = null
    private var items : List<T> = ArrayList<T>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseRecyclerView<V> {
        return BaseRecyclerView<V>(onCreateItemView(parent, viewType))
    }

    protected abstract fun onCreateItemView(parent : ViewGroup?, viewType: Int) : V

    override fun getItemCount(): Int {
        return items.count()
    }

    fun getItems() : List<T> {
        return items
    }

    fun setItems(items : List<T>) {
        this.items = items
    }

    /**
     * Listener Interface
     */
    interface ItemListener<T> {
        fun onItemClicked(view : View, item : T)
    }

    fun getItemListener() : ItemListener<T>? {
        return listener
    }

    fun setItemListener(listener: ItemListener<T>) {
        this.listener = listener
    }
}