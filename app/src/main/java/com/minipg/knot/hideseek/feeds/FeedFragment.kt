package com.minipg.knot.kotlin_feed.features.feeds

import android.app.ActionBar
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droidcba.kedditbysteps.features.news.adapter.FeedAdapter
import com.minipg.kont.kotlin_feed.commons.extensions.inflate
import kotlinx.android.synthetic.main.fragment_feed.*
import rx.schedulers.Schedulers
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.WindowManager
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.common.RxBaseFragment
import rx.android.schedulers.AndroidSchedulers
import java.util.*

/**
 * Created by Knot on 9/4/2017.
 */
class FeedFragment : RxBaseFragment() {

    private val feedsManager by lazy { FeedsManager() }
    private var clicked = false
    private var created = false
    private var x = 0F
    private var y = 0F

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return container?.inflate(R.layout.fragment_feed)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        feedList.setHasFixedSize(true)
        feedList.layoutManager = LinearLayoutManager(activity)
        initAdapter()
        if (savedInstanceState == null) {
            requestFeed()

        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initinstance()
    }

    private fun requestFeed() {
        //(feedList.adapter as FeedAdapter).addAlbum(albumFeeds)
        val subscription = feedsManager.getFeeds()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { retrievedFeeds ->
                            (feedList.adapter as FeedAdapter).addAlbum(retrievedFeeds)
                        },
                        { e ->
                            Snackbar.make(feedList, e.message ?: "", Snackbar.LENGTH_LONG).show()
                        }
                )
        subscriptions.add(subscription)
    }

    private fun initAdapter() {
        if (feedList.adapter == null) {
            feedList.adapter = FeedAdapter()

        }
    }

    private fun initinstance() {
        var r = Random()

        btnGG.setOnClickListener({
            btnGG.visibility = View.GONE
            clicked = true
        })
        svOutside.isFocusableInTouchMode = true
        svOutside.viewTreeObserver.addOnGlobalLayoutListener {
            feedList.layoutParams.height = svOutside.height
            rlInside.layoutParams.height = feedList.getChildAt(0).height
            if (feedList != null && btnGG != null && !clicked) {
                var width = svOutside.width - btnGG.width
                var height = svOutside.getChildAt(0).height - btnGG.height
//                if (!created) {
                x = r.nextInt(width).toFloat()
                y = r.nextInt(height).toFloat()
//                }
                Log.d("ggg", "height " + feedList.measuredHeight.toString())
                Log.d("ggg", "width " + width.toString())
                btnGG.x = x
                btnGG.y = y
                btnGG.visibility = View.VISIBLE
                //created = true
            }

        }

    }
}

