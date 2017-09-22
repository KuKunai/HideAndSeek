package com.minipg.knot.hideseek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*


class Main2Activity : AppCompatActivity() {


    val PREFS_FILENAME = "plengslowtoad"
    val GO_FRAGMENT = "goFragment"
    var prefs: SharedPreferences? = null
    ////////////////////////
    val PREFS_FILENAME2 = "plengslowtoad2"
    val GO_FRAGMENT2 = "goFragment2"
    var prefs2: SharedPreferences? = null
    /////////////////////////
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

        refresh.setOnClickListener {
            val i = Intent(application, Main2Activity::class.java)
            startActivity(i)
            finish()
        }
        fragment1.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "1")
            editor.apply()
        }

        fragment2.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "2")
            editor.apply()
        }

        fragment3.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "3")
            editor.apply()
        }
        fragment4.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "4")
            editor.apply()
        }
        randomFrag.setOnClickListener {
            val rand = Random()
            val numberrandom = rand.nextInt(4) + 1
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, numberrandom.toString())
            editor.apply()
        }
        fab.setOnClickListener { view ->
            val i = Intent(application, MainActivity::class.java)
            startActivity(i)
        }

        prefs2 = this.getSharedPreferences(PREFS_FILENAME2, 0)
        val fragShow2 = prefs2!!.getInt(GO_FRAGMENT2, 0)
//            Toast.makeText(this, fragShow2, Toast.LENGTH_SHORT).show()
        tv_score.text = fragShow2.toString()
    }
}
