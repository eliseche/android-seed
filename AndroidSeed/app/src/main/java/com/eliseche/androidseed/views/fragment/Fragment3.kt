package com.eliseche.androidseed.views.fragment

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.R
import com.eliseche.androidseed.databinding.Fragment3Binding
import com.eliseche.androidseed.extensions.onChange
import com.eliseche.androidseed.viewmodels.ViewModelFragment3
import kotlinx.android.synthetic.main.fragment_3.*

class Fragment3 : Fragment() {
    private lateinit var viewModelFragment3: ViewModelFragment3

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModelFragment3 = ViewModelProviders.of(this).get(ViewModelFragment3::class.java)

        val binding: Fragment3Binding? = DataBindingUtil.inflate(inflater, R.layout.fragment_3, container, false)
        val rootView = binding?.root
        binding?.setVariable(BR.viewModelFragment3, viewModelFragment3)
        binding?.run {
            lifecycleOwner = activity
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        viewModelFragment3.init()
    }

    //region Setup
    private fun init() {
        checkbox_show_container.setOnClickListener {
            viewModelFragment3.isVisible.postValue(checkbox_show_container.isChecked)
        }

        edittext_input.onChange {
            viewModelFragment3.someText.postValue(it)
        }

        checkbox_show_container.isChecked = true
    }
    //endregion
}