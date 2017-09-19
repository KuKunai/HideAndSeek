package com.minipg.knot.hideseek

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.support.v4.widget.NestedScrollView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.Window
import android.widget.ImageView
import kotlinx.android.synthetic.main.customdialog.*
import java.util.*

/**
 * Created by User on 15/9/2560.
 */
class AnimetionDialog(btnGG: ImageView, context: Context, svOutside: NestedScrollView) : AppCompatActivity() {
    private var clicked = false
    private var created = false
    private var x = 0F
    private var y = 0F

    val btnGG: ImageView = btnGG
    val context: Context = context
    val svOutside: NestedScrollView = svOutside

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

    fun initinstance() {
        var r = Random()

        btnGG.setOnClickListener({
            custom_dialog()
//            btnGG.visibility = View.GONE
            clicked = true
        })
        btnGG.visibility = View.VISIBLE

        svOutside.viewTreeObserver.addOnGlobalLayoutListener {
            if (svOutside != null && btnGG != null && !clicked) {
                val width = svOutside.width - btnGG.width
                val height = svOutside.getChildAt(0).height - btnGG.height
                if (!created) {
                    x = r.nextInt(width).toFloat()
                    y = r.nextInt(height).toFloat()
                }
                Log.d("ggg", height.toString())
                Log.d("ggg", width.toString())
                btnGG.x = x
                btnGG.y = y
                btnGG.visibility = View.VISIBLE
                created = true

            }
        }


    }

    fun custom_dialog() {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.customdialog)
        dialog.setCancelable(true)
        dialog.textView1.text = "หาเราเจอได้ไง!"
        dialog.textView2.text = "ได้รับ ♥ 1 ดวง"

        dialog.button1.setOnClickListener { ob ->
            setAnimation()
            dialog.cancel()
        }
        dialog.show()
    }


}