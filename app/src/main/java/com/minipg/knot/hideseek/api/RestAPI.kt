package com.minipg.knot.kotlin_feed.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Knot on 9/7/2017.
 */
class RestAPI() {

    private val fansterAPI: FansterAPI

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        fansterAPI = retrofit.create(FansterAPI::class.java)
    }

    fun getFeeds(after: String, limit: String): Call<FansterFeedsResponse> {
        return fansterAPI.getTop(after,limit)
    }
}