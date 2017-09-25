package com.minipg.knot.hideseek

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.CountDownTimer
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
    ////////////////////////ตัวแปลแสดงสถานะ รอคูดาวของ mascot
    val mascotColldown = null
    ////////////////////////ใช้เก็บคะแนน เมื่อกด mascot
    val PREFS_FILENAME2 = "plengslowtoad2"
    val GO_FRAGMENT2 = "goFragment2"
    var prefs2: SharedPreferences? = null
    //////////////////////////ใช้สุ่มหน้าที่ต้องการ
    val PREFS_FILENAME = "plengslowtoad"
    val GO_FRAGMENT = "goFragment"
    var prefs: SharedPreferences? = null
    /////////////////////////Random คะแนน เมื่อกดเจอ Mascot
    val rand = Random()
    val ScoreRandom = rand.nextInt(4) + 1
    /////////////////////////ใช้นับเวลาคูดาวน์
    var cdt: CountDownTimer? = null
    /////////////////////////

    val btnGG: ImageView = btnGG
    val context: Context = context
    val svOutside: NestedScrollView = svOutside


    fun initinstance() {
//        if (mascotColldown == 1) {
        var r = Random()
        btnGG.setOnClickListener({
            ////////////////กดแล้วว ทำให้ได้คะแนน
            prefs2 = context.getSharedPreferences(PREFS_FILENAME2, 0)
            val editor = prefs2!!.edit()
            val putGG = prefs2!!.getInt(GO_FRAGMENT2, 0)
            editor.putInt(GO_FRAGMENT2, ScoreRandom + putGG)
            editor.apply()

            ////////กดแล้ว โชว์ Dialog
            custom_dialog()
//            btnGG.visibility = View.GONE
            clicked = true
        })
        svOutside.viewTreeObserver.addOnGlobalLayoutListener {
            if (svOutside != null && btnGG != null && !clicked) {
                val width = svOutside.width - btnGG.width
                val height = svOutside.getChildAt(0).height - btnGG.height
                if (!created) {
                    x = r.nextInt(width) - 10.toFloat()
                    y = r.nextInt(height) - 10.toFloat()
                }
                Log.d("ggg", height.toString())
                Log.d("ggg", width.toString())
                btnGG.x = x
                btnGG.y = y
                btnGG.visibility = View.VISIBLE
                created = false

            }
        }
//        }
    }

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
        if (btnGG.scaleX != 0f) {
            btnGG.isEnabled = false
        } else {
            btnGG.visibility = View.INVISIBLE
        }
    }

    fun custom_dialog() {

        val dialog = Dialog(context)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.setContentView(R.layout.customdialog)
        dialog.setCancelable(true)
        dialog.textView1.text = "หาเราเจอได้ไง!"
        dialog.textView2.text = "ได้รับ ♥ " + ScoreRandom.toString() + " ดวง"

        dialog.button1.setOnClickListener { ob ->
            btnGG.isEnabled
            setAnimation()
            dialog.cancel()
            //////////////////////////////////ทำให้มันรอเวลา ถึงจะเกิด mascot อีกครั้ง
            prefs = context.getSharedPreferences(PREFS_FILENAME, 0)
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "0")
            editor.apply()
            cdt = object : CountDownTimer(10000, 1000) {
                override fun onTick(millisUntilFinished: Long) {

                }

                override fun onFinish() {
                    val rand = Random()
                    val numberrandom = rand.nextInt(4) + 1
                    val editor = prefs!!.edit()
                    editor.putString(GO_FRAGMENT, numberrandom.toString())
                    editor.apply()

                }
            }.start()
            //////////////////////////////////ปิด คูดาวน์
        }
        dialog.show()
    }


}