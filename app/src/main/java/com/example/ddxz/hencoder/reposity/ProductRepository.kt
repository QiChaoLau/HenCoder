package com.example.ddxz.hencoder.reposity

import com.ddxz.baseapp.repository.base.BaseRepository
import com.example.ddxz.hencoder.model.reposity.ActBanner
import com.example.ddxz.hencoder.net.retrofit.Api

/**
 * author:LauQiChao
 * date:On 2019/9/16.
 */
class ProductRepository(private val api : Api) : BaseRepository() {

    suspend fun getActBanner(id : Int) : ActBanner? = safeApiCall(
            call = {api.activityBanner(id).await()},
            errorMessage = "Error Fetching Act Banner"
        )
}