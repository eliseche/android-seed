package com.eliseche.androidseed.repository.remote

import android.util.Log
import com.eliseche.androidseed.Urls
import com.eliseche.androidseed.model.Post
import com.eliseche.androidseed.repository.HttpClient
import com.eliseche.androidseed.repository.PHResult
import com.google.gson.Gson
import okhttp3.Request

class ServicePost {
    fun getPosts(completion: (PHResult<List<Post>>) -> Unit) {
        val request = Request.Builder()
            .url(Urls.URL_GET_POSTS)
            .build()

        HttpClient.instance.makeRequest(request, Array<Post>::class.java) {
            if (it is PHResult.success) {
                completion(PHResult.success(it.data.toList()))
            } else if (it is PHResult.error) {
                completion(it)
            }
        }
    }
}