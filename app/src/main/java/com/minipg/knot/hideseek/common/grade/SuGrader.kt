package com.minipg.knot.kotlin_feed.common.grade

/**
 * Created by Knot on 9/1/2017.
 */
class SuGrader(val satisfy: Int = 60): Grader {
    init {
        if (satisfy<0 || satisfy>100)
            throw IllegalArgumentException("A satisfy $satisfy is out of score range of 0-100")
    }

    override fun grade(score: Int) = when(score){
        in satisfy..100 ->"S"
        in 0 until satisfy ->"U"
        else -> "???"
    }
}