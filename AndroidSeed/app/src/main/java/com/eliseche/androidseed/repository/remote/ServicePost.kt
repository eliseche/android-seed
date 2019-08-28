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

        HttpClient.instance.makeRequest(request) {
            if (it is PHResult.success) {
                try {
                    val posts = Gson().fromJson(it.data, Array<Post>::class.java).toMutableList()

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