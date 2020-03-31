package com.eliseche.androidseed.views.adapters

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.views.interfaces.IItemListener
import com.eliseche.androidseed.views.interfaces.IViewModelBase

class DataBindingViewModelViewHolder<T, K>(private val viewDataBinding: ViewDataBinding, private val callback: IItemListener?) : RecyclerView.ViewHolder(viewDataBinding.root) {
    init {
        if (callback != null)
            viewDataBinding.setVariable(BR.callback, callback)
    }

    fun bind(item: T, viewModelType: Class<K>) {
        val viewModel = viewModelType.newInstance() as IViewModelBase
        viewModel.setItem(item)
        viewDataBinding.setVariable(BR.item, viewModel)
        viewDataBinding.executePendingBindings()
    }
}