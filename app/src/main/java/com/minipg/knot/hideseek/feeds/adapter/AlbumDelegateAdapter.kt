package com.minipg.knot.kotlin_feed.features.feeds.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.common.adapter.ViewType
import com.minipg.knot.kotlin_feed.common.adapter.ViewTypeDelegateAdapter
import com.minipg.knot.kotlin_feed.features.feeds.FeedsAlbumItem
import com.minipg.knot.kotlin_feed.features.feeds.FeedsPhotoItem
import com.minipg.kont.kotlin_feed.commons.extensions.getFriendlyTime
import com.minipg.kont.kotlin_feed.commons.extensions.inflate
import kotlinx.android.synthetic.main.feed_item_album.view.*

/**
 * Created by Knot on 9/4/2017.
 */
class AlbumDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return TurnsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as FeedsAlbumItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.feed_item_album)) {

        fun bind(item: FeedsAlbumItem) = with(itemView) {
            //Picasso.with(itemView.context).load(item.thumbnail).into(img_thumbnail)
            //ivPicture.loadImg(item.thumbnail)
            tvDescription.text = item.title
            tvAuthor.text = item.author
            //TODO item.thumbnail.size
            //comments.text = "${item.numComments} comments"
            tvTime.text = item.created.getFriendlyTime()
            Log.d("Tag", item.thumbnail.size.toString())
            when (item.thumbnail.size) {
                0 -> {
                    llLow1.visibility = View.GONE
                    llLow2.visibility = View.GONE
                }
                1 -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 1F
                    ivPicture2.visibility = View.GONE

                    llLow2.visibility = View.GONE
                }
                2 -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 2F
                    ivPicture2.visibility = View.VISIBLE

                    llLow2.visibility = View.GONE
                }
                3 -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 1F
                    ivPicture2.visibility = View.GONE

                    llLow2.visibility = View.VISIBLE
                    llLow2.weightSum = 2F
                    rlPicture5.visibility = View.GONE
                }
                4 -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 1F
                    ivPicture2.visibility = View.GONE

                    llLow2.visibility = View.VISIBLE
                    llLow2.weightSum = 3F
                    rlPicture5.visibility = View.VISIBLE
                    viewShade.visibility = View.GONE
                    tvImageAmount.visibility = View.GONE
                }
                5 -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 2F
                    ivPicture2.visibility = View.VISIBLE

                    llLow2.visibility = View.VISIBLE
                    llLow2.weightSum = 3F
                    rlPicture5.visibility = View.VISIBLE
                    viewShade.visibility = View.GONE
                    tvImageAmount.visibility = View.GONE
                }
                else -> {
                    llLow1.visibility = View.VISIBLE
                    llLow1.weightSum = 2F
                    ivPicture2.visibility = View.VISIBLE

                    llLow2.visibility = View.VISIBLE
                    llLow2.weightSum = 3F
                    rlPicture5.visibility = View.VISIBLE
                    viewShade.visibility = View.VISIBLE
                    tvImageAmount.visibility = View.VISIBLE
                    val i = item.thumbnail.size-5
                    tvImageAmount.text = "+$i"
                }
            }

        }
    }
}