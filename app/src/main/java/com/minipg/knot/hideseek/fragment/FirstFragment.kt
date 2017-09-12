package com.minipg.knot.hideseek.fragment

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.Fragment
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.RelativeLayout
import com.minipg.knot.hideseek.R
import kotlinx.android.synthetic.main.fragment_one.*
import java.util.*

/**
 * Created by Knot on 9/8/2017.
 */
class FirstFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_one, container, false)

    }

    override fun onStart() {
        super.onStart()
        initinstance()
    }

    private fun initinstance() {
        var r = Random()
        var metric = DisplayMetrics()
        activity.windowManager.defaultDisplay.getMetrics(metric)
        btnGG.text = "go"

        svOutside.viewTreeObserver.addOnGlobalLayoutListener {
            if(svOutside!=null && btnGG!=null){
                val height = svOutside.getChildAt(0).height - btnGG.height
                val width = svOutside.width-btnGG.width
                val x = r.nextInt(width).toFloat()
                Log.d("ggg","X = $x")
                val y = r.nextInt(height).toFloat()
                Log.d("ggg","Y = $y")
                Log.d("ggg",height.toString())
                Log.d("ggg",width.toString())
                btnGG.x = x
                btnGG.y = y
            }

        }



    }
}