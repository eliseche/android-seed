package com.eliseche.androidseed.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class ViewModelFragment3 : ViewModel() {
    val isVisible = MutableLiveData<Boolean>()
    val someText = MutableLiveData<String>()

    init {
        isVisible.value = true
        someText.value = "Hi, this is HTML with <b>bold</b> and with this <font color='#ff0000'>color</font>. " +
                "We are using Html.from() in .xml with Data binding."
    }

    fun init() {
    }
}