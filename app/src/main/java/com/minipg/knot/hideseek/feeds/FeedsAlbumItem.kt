package com.minipg.knot.kotlin_feed.features.feeds

import com.minipg.knot.kotlin_feed.common.adapter.AdapterConstants
import com.minipg.knot.kotlin_feed.common.adapter.ViewType

/**
 * Created by Knot on 9/4/2017.
 */
data class FeedsAlbumItem(
        val author: String,
        val title: String,
        val numComments: Int,
        val created: Long,
        val thumbnail: List<String>,
        val url: String
) : ViewType {
    override fun getViewType() = AdapterConstants.ALBUM
}