package com.example.basicapp.Api

import com.example.basicapp.Models.Quote
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers


interface TweetsyApi {
    @GET("/v3/b/66484ea0e41b4d34e4f58513?meta=false")
    suspend fun getquotes(@Header("X-JSON-Path") id: String): Response<List<Quote>>
    //Header is for dyanmic and headers is for static

    @GET("/v3/b/66484ea0e41b4d34e4f58513?meta=false")
    @Headers("X-JSON-Path:quotes..id")
    suspend fun getccategory(): Response<List<Int>>
}