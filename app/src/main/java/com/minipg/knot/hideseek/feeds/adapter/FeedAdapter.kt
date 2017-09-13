package com.droidcba.kedditbysteps.features.news.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.minipg.knot.kotlin_feed.common.FansterFeedsItem
import com.minipg.knot.kotlin_feed.features.feeds.FeedsItem
import com.minipg.knot.kotlin_feed.common.adapter.AdapterConstants
import com.minipg.knot.kotlin_feed.common.adapter.ViewType
import com.minipg.knot.kotlin_feed.common.adapter.ViewTypeDelegateAdapter
import com.minipg.knot.kotlin_feed.features.feeds.FeedsAlbumItem
import com.minipg.knot.kotlin_feed.features.feeds.FeedsPhotoItem
import com.minipg.knot.kotlin_feed.features.feeds.adapter.AlbumDelegateAdapter
import com.minipg.knot.kotlin_feed.features.feeds.adapter.FeedDelegateAdapter
import com.minipg.knot.kotlin_feed.features.feeds.adapter.PhotoDelegateAdapter
import java.util.*

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.FEED, FeedDelegateAdapter())
        delegateAdapters.put(AdapterConstants.PHOTO, PhotoDelegateAdapter())
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.ALBUM, AlbumDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int): Int {
        return this.items.get(position).getViewType()
    }

    fun addFeed(feed: List<FansterFeedsItem>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(feed)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun addPhoto(feed: List<FeedsPhotoItem>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(feed)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun addAlbum(feed: List<FeedsAlbumItem>) {
        // first remove loading and notify
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)

        // insert news and the loading at the end of the list
        items.addAll(feed)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1 /* plus loading item */)
    }

    fun clearAndAddFeed(feed: List<FeedsItem>) {
        items.clear()
        notifyItemRangeRemoved(0, getLastPosition())

        items.addAll(feed)
        items.add(loadingItem)
        notifyItemRangeInserted(0, items.size)
    }

    fun getFeed(): List<FeedsItem> {
        return items
                .filter { it.getViewType() == AdapterConstants.FEED }
                .map { it as FeedsItem }
    }

    private fun getLastPosition() = if (items.lastIndex == -1) 0 else items.lastIndex
}