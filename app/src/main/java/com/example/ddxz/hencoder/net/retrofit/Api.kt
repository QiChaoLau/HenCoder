package com.example.ddxz.hencoder.net.retrofit

import com.example.ddxz.hencoder.model.reposity.ActBanner
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * author:LauQiChao
 * date:On 2019/9/15.
 */
interface Api {
    @GET("product/activityBanner")
    fun activityBanner(@Path("id") id:Int): Deferred<Response<ActBanner>>
}