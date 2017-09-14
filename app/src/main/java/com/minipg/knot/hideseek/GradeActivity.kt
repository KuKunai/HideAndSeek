package com.minipg.knot.kotlin_feed.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.minipg.knot.hideseek.R
import com.minipg.knot.kotlin_feed.common.grade.Grader
import com.minipg.knot.kotlin_feed.common.grade.SuGrader
import com.minipg.knot.kotlin_feed.common.grade.TypicalGrader
import kotlinx.android.synthetic.main.activity_grade.*

class GradeActivity : AppCompatActivity() {

    private var grader: Grader = TypicalGrader()
    private val satisfy = 50

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grade)

        btnSend.setOnClickListener{ view ->
            val s = etScore.text.toString()
            if(s.isNotBlank()){
                try {
                    val i  = s.toInt()
                    etScore.setText("")
                    tvGrade.text = grader.grade(i)
                } catch (e: NumberFormatException) {
                    Toast.makeText(this,"Hey! $s is not an Int",Toast.LENGTH_SHORT).show()
                }
            }
        }

        rgSwitch.setOnCheckedChangeListener { radioGroup, i ->
            when(i){
                R.id.rbTypical -> grader = TypicalGrader()
                R.id.rbSU -> grader = SuGrader(satisfy)
            }
        }
    }
}
