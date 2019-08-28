package com.eliseche.androidseed.repository.remote

import android.util.Log
import com.eliseche.androidseed.Urls
import com.eliseche.androidseed.model.Album
import com.eliseche.androidseed.model.Photo
import com.eliseche.androidseed.repository.HttpClient
import com.eliseche.androidseed.repository.PHResult
import com.google.gson.Gson
import okhttp3.Request

class ServiceAlbum {
    fun getAlbums(completion: (PHResult<List<Album>>) -> Unit) {
        val request = Request.Builder()
                .url(Urls.URL_GET_ALBUMS)
                .build()

        HttpClient.instance.makeRequest(request) {
            if (it is PHResult.success) {
                try {
                    val posts = Gson().fromJson(it.data, Array<Album>::class.java).toMutableList()

                    completion(PHResult.success(posts))
                } catch (e: Exception) {
                    Log.e(javaClass.name, e.message)

                    completion(PHResult.error(e.message, null))
                }
            } else if (it is PHResult.error) {
                Log.e(javaClass.name, it.error)

                completion(it)
            }
        }
    }

    fun getPhotos(completion: (PHResult<List<Photo>>) -> Unit) {
        val request = Request.Builder()
                .url(Urls.URL_GET_PHOTOS)
                .build()

        HttpClient.instance.makeRequest(request) {
            if (it is PHResult.success) {
                try {
                    val posts = Gson().fromJson(it.data, Array<Photo>::class.java).toMutableList()

                    completion(PHResult.success(posts))
                } catch (e: Exception) {
                    Log.e(javaClass.name, e.message)

                    completion(PHResult.error(e.message, null))
                }
            } else if (it is PHResult.error) {
                Log.e(javaClass.name, it.error)

                completion(it)
            }
        }
    }

    fun getPhotos(albumId: Int, completion: (PHResult<List<Photo>>) -> Unit) {
        val request = Request.Builder()
                .url(String.format(Urls.URL_GET_PHOTO, albumId.toString()))
                .build()

        HttpClient.instance.makeRequest(request) {
            if (it is PHResult.success) {
                try {
                    val posts = Gson().fromJson(it.data, Array<Photo>::class.java).toMutableList()

                    completion(PHResult.success(posts))
                } catch (e: Exception) {
                    Log.e(javaClass.name, e.message)

                    completion(PHResult.error(e.message, null))
                }
            } else if (it is PHResult.error) {
                Log.e(javaClass.name, it.error)

                completion(it)
            }
        }
    }
}