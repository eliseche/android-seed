package com.eliseche.androidseed.repository

import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.model.Photo
import com.eliseche.androidseed.repository.remote.ServiceAlbum

class RepositoryAlbum {
    private val serviceAlbum = ServiceAlbum()

    fun getAlbums(completion: (PHResult<List<Album>>) -> Unit) {
        serviceAlbum.getAlbums(completion)
    }

    fun getPhotos(completion: (PHResult<List<Photo>>) -> Unit) {
        serviceAlbum.getPhotos(completion)
    }

    fun getPhotos(albumId: Int, completion: (PHResult<List<Photo>>) -> Unit) {
        serviceAlbum.getPhotos(albumId, completion)
    }
}