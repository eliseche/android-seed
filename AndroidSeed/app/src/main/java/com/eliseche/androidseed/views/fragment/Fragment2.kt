package com.eliseche.androidseed.views.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eliseche.androidseed.BR
import com.eliseche.androidseed.R
import com.eliseche.androidseed.databinding.Fragment2Binding
import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.model.Photo
import com.eliseche.androidseed.viewmodels.ViewModelFragment2
import com.eliseche.androidseed.viewmodels.item.ViewModelItemAlbum
import com.eliseche.androidseed.views.adapters.DataBindingModelAdapter
import com.eliseche.androidseed.views.adapters.DataBindingViewModelAdapter
import kotlinx.android.synthetic.main.fragment_2.*

class Fragment2 : Fragment() {
    private lateinit var viewModelFragment2: ViewModelFragment2
    private lateinit var adapterAlbums: DataBindingViewModelAdapter<Album, ViewModelItemAlbum>
    private lateinit var adapterPhotos: DataBindingModelAdapter<Photo>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModelFragment2 = ViewModelProviders.of(this).get(ViewModelFragment2::class.java)

        val binding: Fragment2Binding? = DataBindingUtil.inflate(inflater, R.layout.fragment_2, container, false)
        val rootView = binding?.root
        binding?.setVariable(BR.viewModelFragment2, viewModelFragment2)
        binding?.run {
            lifecycleOwner = activity
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        viewModelFragment2.init()
    }

    //region Setup
    private fun init() {
        adapterAlbums = DataBindingViewModelAdapter(R.layout.item_album, ViewModelItemAlbum::class.java, viewModelFragment2)
        list_albums.layoutManager = GridLayoutManager(activity, 1)
        list_albums.setHasFixedSize(true)
        list_albums.adapter = adapterAlbums

        adapterPhotos = DataBindingModelAdapter(R.layout.item_photo, viewModelFragment2)
        list_photos.layoutManager = GridLayoutManager(activity, 1)
        list_photos.setHasFixedSize(true)
        list_photos.adapter = adapterPhotos

        viewModelFragment2.albums.observe(this, Observer {
            it?.let {
                adapterAlbums.setItems(it)
                adapterAlbums.notifyDataSetChanged()
            }
        })

        viewModelFragment2.photos.observe(this, Observer {
            it?.let {
                adapterPhotos.setItems(it)
                adapterPhotos.notifyDataSetChanged()
            }
        })
    }
    //endregion
}