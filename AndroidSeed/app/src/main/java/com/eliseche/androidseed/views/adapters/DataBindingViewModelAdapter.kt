package com.eliseche.androidseed.views.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.eliseche.androidseed.views.interfaces.IItemListener

open class DataBindingViewModelAdapter<T, K>(layoutId: Int, viewModelType: Class<K>, callback: IItemListener? = null) : RecyclerView.Adapter<DataBindingViewModelViewHolder<T, K>>() {
    private var layoutId = layoutId
    private val callback = callback
    private val viewModelType = viewModelType
    private var items: List<T> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewModelViewHolder<T, K> {
        val viewDataBinding: ViewDataBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.context), layoutId, parent, false)
        return DataBindingViewModelViewHolder(viewDataBinding, callback)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DataBindingViewModelViewHolder<T, K>, position: Int) {
        val item = items[position]
        holder.bind(item, viewModelType)
    }

    fun setItems(items: List<T>) {
        this.items = items
    }

    fun getItems() = items
}