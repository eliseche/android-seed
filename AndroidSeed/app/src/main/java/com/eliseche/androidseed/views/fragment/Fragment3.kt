package com.eliseche.androidseed.views.fragment

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.R
import com.eliseche.androidseed.databinding.Fragment3Binding
import com.eliseche.androidseed.viewmodels.ViewModelFragment3

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
        /*
        adapterPromo = DataBindingViewModelAdapter(R.layout.item_promo, ViewModelItemPromotion::class.java, viewModelTraining)
        list_promo.layoutManager = GridLayoutManager(activity, 1)
        list_promo.setHasFixedSize(true)
        list_promo.adapter = adapterPromo

        viewModelTraining.promos.observe(this, Observer {
            it?.let {
                refreshPromotions(it)
            }
        })*/
    }
    //endregion
}