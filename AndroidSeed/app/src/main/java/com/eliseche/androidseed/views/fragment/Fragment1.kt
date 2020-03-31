package com.eliseche.androidseed.views.fragment

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.R
import com.eliseche.androidseed.databinding.Fragment1Binding
import com.eliseche.androidseed.model.Post
import com.eliseche.androidseed.viewmodels.ViewModelFragment1
import com.eliseche.androidseed.views.adapters.DataBindingModelAdapter
import kotlinx.android.synthetic.main.fragment_1.*

class Fragment1 : Fragment() {
    private lateinit var viewModelFragment1: ViewModelFragment1
    private lateinit var adapterPosts: DataBindingModelAdapter<Post>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModelFragment1 = ViewModelProviders.of(this).get(ViewModelFragment1::class.java)

        val binding: Fragment1Binding? = DataBindingUtil.inflate(inflater, R.layout.fragment_1, container, false)
        val rootView = binding?.root
        binding?.setVariable(BR.viewModelFragment1, viewModelFragment1)
        binding?.run {
            lifecycleOwner = activity
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        viewModelFragment1.init()
    }

    //region Setup
    private fun init() {
        adapterPosts = DataBindingModelAdapter(R.layout.item_post, viewModelFragment1)
        list_posts.layoutManager = GridLayoutManager(activity, 1)
        list_posts.setHasFixedSize(true)
        list_posts.adapter = adapterPosts

        viewModelFragment1.posts.observe(this, Observer {
            it?.let {
                adapterPosts.setItems(it)
                adapterPosts.notifyDataSetChanged()
            }
        })
    }
    //endregion
}