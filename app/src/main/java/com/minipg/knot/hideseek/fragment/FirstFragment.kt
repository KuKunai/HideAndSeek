package com.minipg.knot.hideseek.fragment

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.minipg.knot.hideseek.R
import kotlinx.android.synthetic.main.customdialog.*
import kotlinx.android.synthetic.main.fragment_one.*
import java.util.*

/**
 * Created by Knot on 9/8/2017.
 */
class FirstFragment() : Fragment() {

    private var clicked = false
    private var created = false
    private var x = 0F
    private var y = 0F

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_one, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initinstance()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }


    private fun initinstance() {
        var r = Random()

        btnGG.setOnClickListener({
            custom_dialog()
//            btnGG.visibility = View.GONE
            clicked = true
        })

//        svOutside.viewTreeObserver.addOnGlobalLayoutListener {
//
//            if (svOutside != null && btnGG != null && !clicked) {
//                val width = svOutside.width - btnGG.width
//                val height = svOutside.getChildAt(0).height - btnGG.height
//                if (!created) {
//                    x = r.nextInt(width).toFloat()
//                    y = r.nextInt(height).toFloat()
//                }
//                Log.d("ggg", height.toString())
//                Log.d("ggg", width.toString())
//                btnGG.x = x
//                btnGG.y = y
//                btnGG.visibility = View.VISIBLE
//                created = true
//
//            }
//
//        }

    }

//    private fun setAnimation() {
//        val ran1 = (Math.random() * 100).toInt() + 0
//        val animSet1 = AnimatorSet()
//
//        val animX1 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, 3f)
//        val animY1 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 3f)
//        animSet1.playTogether(animX1, animY1)
//
//        val animSet2 = AnimatorSet()
//        val animX2 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, 1f)
//        val animY2 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 1f)
//        animSet2.playTogether(animX2, animY2)
//
//        val animSet3 = AnimatorSet()
//        val animX3 = ObjectAnimator.ofFloat(btnGG, View.SCALE_X, 0f)
//        val animY3 = ObjectAnimator.ofFloat(btnGG, View.SCALE_Y, 0f)
//        animSet3.playTogether(animX3, animY3)
//
//        val animSet = AnimatorSet()
//        animSet.playSequentially(animSet1, animSet2, animSet3)
//        animSet.duration = 500
//        animSet.start()
//    }

    fun custom_dialog() {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.customdialog)
        dialog.setCancelable(true)
        dialog.textView1.text = "หาเราเจอได้ไง!"
        dialog.textView2.text = "ได้รับ ♥ 1 ดวง"

        dialog.button1.setOnClickListener { ob ->
            //setAnimation()
            dialog.cancel()
        }
        dialog.show()
    }


//    private fun setRandomFragment() {
//        val random = Random()
//        randomFragmentNum = random.nextInt(2)
//        when (randomFragmentNum) {
//            0 -> R.layout.fragment_one
//            1 -> R.layout.fragment_two
//            2 -> R.layout.fragment_three
//        }
//
//    }
}
