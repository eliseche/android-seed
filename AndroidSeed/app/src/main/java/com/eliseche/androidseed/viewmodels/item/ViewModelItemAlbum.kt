package com.eliseche.androidseed.viewmodels.item

import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.views.interfaces.IViewModelBase

class ViewModelItemAlbum : IViewModelBase {
    var album: Album? = null

    override fun setItem(item: Any?) {
        if (item is Album)
            album = item
    }
}