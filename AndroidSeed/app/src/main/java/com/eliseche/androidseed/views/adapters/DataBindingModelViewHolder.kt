package com.eliseche.androidseed.views.adapters

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.views.interfaces.IItemListener

class DataBindingModelViewHolder<T>(private val viewDataBinding: ViewDataBinding, private val callback: IItemListener?) : RecyclerView.ViewHolder(viewDataBinding.root) {
    init {
        if (callback != null)
            viewDataBinding.setVariable(BR.callback, callback)
    }

    fun bind(item: T) {
        viewDataBinding.setVariable(BR.item, item)
        viewDataBinding.executePendingBindings()
    }
}