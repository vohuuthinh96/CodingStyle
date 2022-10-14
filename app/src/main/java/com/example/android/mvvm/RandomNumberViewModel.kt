package com.example.android.mvvm

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random


/**
 * Created by Thinhvh on 14/10/2022.
 * Phone: 0398477967
 * Email: thinhvh.fpt@gmail.com
 */
class RandomNumberViewModel : ViewModel() {
    var stringRandomLiveData = MutableLiveData<String>()
    var intRandomLiveData = MutableLiveData<Int>()

    var intAndStringRandomLiveData = MediatorLiveData<Any>()

    init {
        intAndStringRandomLiveData.addSource(stringRandomLiveData){
            intAndStringRandomLiveData.value = it
        }

        intAndStringRandomLiveData.addSource(intRandomLiveData){
            intAndStringRandomLiveData.value = it.toString()
        }

    }

    fun getStringRandom(){
        stringRandomLiveData.postValue("abc")
    }

    fun getIntRandom(){
        intRandomLiveData.postValue(Random.nextInt())
    }


}