package com.eliseche.androidseed.repository

import com.eliseche.androidseed.model.Post
import com.eliseche.androidseed.repository.remote.ServicePost

class RepositoryPost {
    private val serviePosts = ServicePost()

    fun getPosts(completion: (PHResult<List<Post>>) -> Unit) {
        serviePosts.getPosts(completion)
    }
}