package com.minipg.knot.kotlin_feed.features.feeds

import com.minipg.knot.kotlin_feed.api.RestAPI
import com.minipg.knot.kotlin_feed.common.FansterFeedsItem
import rx.Observable

/**
 * News Manager allows you to request more news from Reddit.
 *
 * @author juancho
 */
class FeedsManager(private val api: RestAPI = RestAPI()) {

//    fun getFeeds(limit: String = "10"): Observable<List<FansterFeedsItem>> {
//        return Observable.create {
//            subscriber ->
//            val callResponse = api.getFeeds("",limit)
//            val response = callResponse.execute()
//
//            if (response.isSuccessful){
//                val feeds = response.body()?.data?.children?.map {
//                    val item = it.data
//                    FansterFeedsItem(item.author,item.title,
//                            item.num_comments,item.created,item.thumbnail,
//                            item.url)
//                }
//                subscriber.onNext(feeds)
//                subscriber.onCompleted()
//            } else {
//                subscriber.onError(Throwable(response.message()))
//            }
//        }
//    }

    //Mock
    fun getFeeds(): Observable<List<FeedsAlbumItem>> {
        return Observable.create { subscriber ->
            val news = mutableListOf<FeedsAlbumItem>()
            for (i in 0..7) {
                val list = mutableListOf<String>()
                for (j in 1..i) {
                    list.add("A")
                }
                news.add(FeedsAlbumItem(
                        "author$i",
                        "Title $i",
                        i, // number of comments
                        1457207701L - i * 200, // time
                        list, // image url
                        "url"
                ))
            }
            subscriber.onNext(news)
        }
    }
}