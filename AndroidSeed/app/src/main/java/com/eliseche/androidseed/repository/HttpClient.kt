package com.eliseche.androidseed.repository

import okhttp3.*
import java.io.IOException
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

    fun makeRequest(customClient: OkHttpClient, request: Request, completion: (PHResult<String>) -> Unit) {
        executeRequest(customClient, request, completion)
    }

    fun makeRequest(request: Request, completion: (PHResult<String>) -> Unit) {
        executeRequest(client, request, completion)
    }

    private fun executeRequest(client: OkHttpClient, request: Request, completion: (PHResult<String>) -> Unit) {
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    try {
                        val resultString = response.body()?.string()

                        completion(PHResult.success(resultString!!))
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