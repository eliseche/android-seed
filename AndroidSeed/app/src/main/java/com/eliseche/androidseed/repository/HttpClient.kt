package com.eliseche.androidseed.repository

import com.google.gson.Gson
import okhttp3.*
import java.io.IOException
import java.lang.reflect.Type
import java.util.concurrent.TimeUnit

class HttpClient {
    private var client: OkHttpClient

    companion object {
        val instance = HttpClient()
    }

    init {
        client = OkHttpClient.Builder()
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .build()
    }

    fun <T : Any> makeRequest(request: Request, type: Class<T>, completion: (PHResult<T>) -> Unit) {
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    try {
                        val resultString = response.body()?.string()

                        val result: T = Gson().fromJson(resultString, type)

                        completion(PHResult.success(result))
                    } catch (e: Exception) {
                        completion(PHResult.error(e.message, response.code()))
                    }
                } else {
                    completion(PHResult.error(response.message(), response.code()))
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                completion(PHResult.error(e.message, null))
            }
        })
    }
}