package com.minipg.knot.kotlin_feed.common

import android.support.v4.app.Fragment
import rx.subscriptions.CompositeSubscription

/**
 * Created by Knot on 9/7/2017.
 */
open class RxBaseFragment() : Fragment() {

    protected  var subscriptions = CompositeSubscription()

    override fun onResume() {
        super.onResume()
        subscriptions = CompositeSubscription()
    }

    override fun onPause() {
        super.onPause()
        subscriptions.clear()
    }
}