package com.example.ddxz.hencoder.net.retrofit

import com.example.ddxz.hencoder.model.constants.CLIENT
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * author:LauQiChao
 * date:On 2019/9/16.
 */
class ApiFactory {
    private val mInterceptor = Interceptor { chain->
        val newUrl = chain.request().url
            .newBuilder()
            .addQueryParameter(CLIENT, "Android")
            .build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()

        chain.proceed(newRequest)
    }

    //OkhttpClient for building http request url
    private val mClient = OkHttpClient().newBuilder()
        .addInterceptor(mInterceptor)
        .build()



    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(mClient)
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(MoshiConverterFactory.create()) // Json解析器
        .addCallAdapterFactory(CoroutineCallAdapterFactory()) // 协程
        .build()


    val mApi : Api = retrofit().create(Api::class.java)
}