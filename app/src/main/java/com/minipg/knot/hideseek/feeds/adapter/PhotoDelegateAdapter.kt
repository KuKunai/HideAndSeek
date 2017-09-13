package com.minipg.knot.kotlin_feed.features.feeds.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.features.feeds.FeedsItem
import com.minipg.knot.kotlin_feed.common.adapter.ViewType
import com.minipg.knot.kotlin_feed.common.adapter.ViewTypeDelegateAdapter
import com.minipg.knot.kotlin_feed.features.feeds.FeedsPhotoItem
import com.minipg.kont.kotlin_feed.commons.extensions.getFriendlyTime
import com.minipg.kont.kotlin_feed.commons.extensions.inflate
import kotlinx.android.synthetic.main.feed_item_photo.view.*

/**
 * Created by Knot on 9/4/2017.
 */
class PhotoDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as FeedsPhotoItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feed_item_photo)) {

        fun bind(item: FeedsPhotoItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            //ivPicture.loadImg(item.thumbnail)
            tvDescription.text = item.title
            tvAuthor.text = item.author
            //comments.text = "${item.numComments} comments"
            tvTime.text = item.created.getFriendlyTime()
        }
    }
}