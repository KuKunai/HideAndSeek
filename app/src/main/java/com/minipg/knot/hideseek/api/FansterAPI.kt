package com.minipg.knot.kotlin_feed.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Knot on 9/7/2017.
 */
interface FansterAPI {
    @GET("/top.json")
    fun getTop(@Query("after") after: String,
               @Query("limit") limit: String): Call<FansterFeedsResponse>
}