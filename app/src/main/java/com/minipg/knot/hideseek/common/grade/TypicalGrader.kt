package com.minipg.knot.kotlin_feed.common.grade

/**
 * Created by Knot on 9/1/2017.
 */
class TypicalGrader : Grader {
    override fun grade(score: Int): String =
            when (score){
                in 80..100 -> "A"
                in 70..79 -> "B"
                in 60..69 -> "C"
                in 50..59 -> "D"
                in 0..49 -> "F"
                else -> "???"
            }
}