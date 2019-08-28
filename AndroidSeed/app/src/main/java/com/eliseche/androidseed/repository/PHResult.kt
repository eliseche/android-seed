package com.eliseche.androidseed.repository

sealed class PHResult<out T : Any> {
    data class success<out T : Any>(val data: T) : PHResult<T>()
    data class error(private var _error: String?, val errorCode: Int?) : PHResult<Nothing>() {
        var error: String
            get() = _error ?: "Unknown Error"
            set(value) {
                _error = value
            }
    }
}