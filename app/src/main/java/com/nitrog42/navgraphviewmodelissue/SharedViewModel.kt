package com.nitrog42.navgraphviewmodelissue

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    val newInstance: LiveData<Boolean> by lazy {
        mld
    }

    private val mld by lazy { MutableLiveData(false) }

    fun newInstanceDisplayed() {
        mld.value = true
    }
}