package com.eliseche.androidseed.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.eliseche.androidseed.model.Post
import com.eliseche.androidseed.repository.PHResult
import com.eliseche.androidseed.repository.RepositoryPost
import com.eliseche.androidseed.views.interfaces.IItemListener
import org.jetbrains.anko.doAsync

class ViewModelFragment1 : ViewModel(), IItemListener {
    private val repositoryPosts = RepositoryPost()
    val posts = MutableLiveData<List<Post>>()
    val actionError = MutableLiveData<String>()

    override fun onSelected(item: Any) {
    }

    fun init() {
        getPosts()
    }

    fun getPosts() {
        doAsync {
            repositoryPosts.getPosts {
                if (it is PHResult.success)
                    posts.postValue(it.data)
                else if (it is PHResult.error)
                    actionError.postValue(it.error)
            }
        }
    }
}