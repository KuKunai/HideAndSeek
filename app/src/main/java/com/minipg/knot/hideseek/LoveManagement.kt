package com.minipg.knot.hideseek

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView

/**
 * Created by User on 15/9/2560.
 */
class LoveManagement(btnGG: ImageView) : AppCompatActivity() {
    val btnGG: ImageView = btnGG
    fun setAnimation() {

        val animSet1 = AnimatorSet()

        val animX1 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, -3f)
        val animY1 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 3f)
        animSet1.playTogether(animX1, animY1)

        val animSet2 = AnimatorSet()
        val animX2 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, 1f)
        val animY2 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 1f)
        animSet2.playTogether(animX2, animY2)

        val animSet3 = AnimatorSet()
        val animX3 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, 0f)
        val animY3 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 0f)
        animSet3.playTogether(animX3, animY3)

        val animSet = AnimatorSet()
        animSet.playSequentially(animSet1, animSet2, animSet3)
        animSet.duration = 500
        animSet.start()
    }
}