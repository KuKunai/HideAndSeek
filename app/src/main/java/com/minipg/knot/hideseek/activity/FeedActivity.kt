package com.minipg.knot.kotlin_feed.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.features.feeds.FeedFragment

class FeedActivity : AppCompatActivity() {

    private var feedFragment: FeedFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feed)
        feedFragment = Fragment.instantiate(this,
                FeedFragment::class.java!!.name) as FeedFragment
        supportFragmentManager.beginTransaction()
                .replace(R.id.contentContainer,feedFragment)
                .commit()
    }
}
