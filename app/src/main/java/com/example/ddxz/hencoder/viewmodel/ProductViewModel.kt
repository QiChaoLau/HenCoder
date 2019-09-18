package com.example.ddxz.hencoder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ddxz.hencoder.model.reposity.ActBanner
import com.example.ddxz.hencoder.net.retrofit.ApiFactory
import com.example.ddxz.hencoder.reposity.ProductRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 * author:LauQiChao
 * date:On 2019/9/18.
 */
class ProductViewModel : ViewModel() {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    private val repository : ProductRepository = ProductRepository(ApiFactory.mApi)


    val actBannerLiveData = MutableLiveData<ActBanner>()

    fun fetchActBanner(id : Int){
        scope.launch {
            val actBanner = repository.getActBanner(id)
            actBannerLiveData.postValue(actBanner)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()

    override fun onCleared() {
        super.onCleared()
        cancelAllRequests()
    }
}