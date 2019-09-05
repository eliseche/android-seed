package com.eliseche.androidseed.viewmodels.item

import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.views.interfaces.IViewModelBase

class ViewModelItemAlbum : IViewModelBase {
    var album: Album? = null

    override fun setItem(item: Any?) {
        if (item is Album)
            album = item
    }

    fun hint() = "That is why we use a ViewModelItem, when we want to perform some data manipulation," +
            "that shouldn't be on the Model."
}