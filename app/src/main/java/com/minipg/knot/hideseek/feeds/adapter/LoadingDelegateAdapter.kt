package com.droidcba.kedditbysteps.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.common.adapter.ViewType
import com.minipg.knot.kotlin_feed.common.adapter.ViewTypeDelegateAdapter
import com.minipg.kont.kotlin_feed.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feed_item_loading)) {
    }
}