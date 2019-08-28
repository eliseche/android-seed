package com.eliseche.androidseed.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.model.Photo
import com.eliseche.androidseed.repository.PHResult
import com.eliseche.androidseed.repository.RepositoryAlbum
import com.eliseche.androidseed.views.interfaces.IItemListener
import org.jetbrains.anko.doAsync

class ViewModelFragment2 : ViewModel(), IItemListener {
    private val repositoryAlbum = RepositoryAlbum()
    val albums = MutableLiveData<List<Album>>()
    val photos = MutableLiveData<List<Photo>>()
    val actionError = MutableLiveData<String>()

    override fun onSelected(item: Any) {
        if (item is Album)
            item?.let {
                getPhotosByAlbumId(it.id)
            }
    }

    fun init() {
        getMusic()
    }

    private fun getMusic() {
        doAsync {
            repositoryAlbum.getAlbums {
                if (it is PHResult.success)
                    albums.postValue(it.data)
                else if (it is PHResult.error)
                    actionError.postValue(it.error)
            }
        }
    }

    fun getPhotosByAlbumId(albumId: Int) {
        doAsync {
            repositoryAlbum.getPhotos(albumId) {
                if (it is PHResult.success)
                    photos.postValue(it.data)
                else if (it is PHResult.error)
                    actionError.postValue(it.error)
            }
        }
    }
}