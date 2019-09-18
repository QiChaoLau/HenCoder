package com.example.ddxz.hencoder.net.retrofit

import com.example.ddxz.hencoder.model.constants.CLIENT
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * author:LauQiChao
 * date:On 2019/9/16.
 */
object ApiFactory {
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

    private val mHttpLoggingInterceptor
            = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    //OkhttpClient for building http request url
    private val mClient = OkHttpClient().newBuilder()
        .addInterceptor(mInterceptor)
        .addInterceptor(mHttpLoggingInterceptor)
        .build()



    fun retrofit() : Retrofit = Retrofit.Builder()
        .client(mClient)
        .baseUrl("https://m.msyc.cc/")
        .addConverterFactory(MoshiConverterFactory.create()) // Json解析器
        .addCallAdapterFactory(CoroutineCallAdapterFactory()) // 协程
        .build()


    val mApi : Api = retrofit().create(Api::class.java)
}