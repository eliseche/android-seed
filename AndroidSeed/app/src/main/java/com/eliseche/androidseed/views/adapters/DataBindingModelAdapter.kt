package com.eliseche.androidseed.views.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eliseche.androidseed.views.interfaces.IItemListener

open class DataBindingModelAdapter<T>(layoutId: Int, callback: IItemListener? = null) : RecyclerView.Adapter<DataBindingModelViewHolder<T>>() {
    private var layoutId = layoutId
    private val callback = callback
    private var items: List<T> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingModelViewHolder<T> {
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false)
        return DataBindingModelViewHolder(viewDataBinding, callback)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DataBindingModelViewHolder<T>, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    fun setItems(items: List<T>) {
        this.items = items
    }

    fun getItems() = items
}