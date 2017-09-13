package com.minipg.knot.kotlin_feed.api

/**
 * Created by Knot on 9/7/2017.
 */
class FansterFeedsResponse(val data: FansterDataResponse)

class FansterDataResponse(
        val children: List<FansterChildrenResponse>,
        val after: String?,
        val before: String?
)

class FansterChildrenResponse(val data: FansterFeedsDataResponse)

class FansterFeedsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String
)