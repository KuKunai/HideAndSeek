package com.minipg.knot.hideseek.fragment

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import com.minipg.knot.hideseek.AnimetionDialog
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
        dialog.getWindow().setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))//ทำให้พื้นหลังใส
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.customdialog)
        dialog.setCancelable(true)
        dialog.textView1.setText("หาเราเจอได้ไง!")
        dialog.textView2.setText("ได้รับ ♥ 1 ดวง")

        dialog.button1.setOnClickListener { ob ->
            //            setAnimation()
            val GG = AnimetionDialog(btnGG) //อนิเมชัน จาก class AnimetionDialog
            GG.setAnimation()//อนิเมชัน จาก class AnimetionDialog
            dialog.cancel()
        }
        dialog.show()
    }

}
