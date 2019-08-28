package com.eliseche.androidseed

/**
 * Application URLs
 */
class Urls {
    companion object {
        const val HOST_API = BuildConfig.HOST_API

        // JSONPlaceholder, fake online REST API for Testing and Prototyping
        const val URL_GET_POSTS = "$HOST_API/posts"
        const val URL_GET_ALBUMS = "$HOST_API/albums"
        const val URL_GET_PHOTOS = "$HOST_API/photos"
        const val URL_GET_PHOTO = "$HOST_API/photos?albumId=%s"
    }
}