package com.minipg.knot.hideseek

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*




class Main2Activity : AppCompatActivity() {


    val PREFS_FILENAME = "plengslowtoad"
    val GO_FRAGMENT = "goFragment"
    var prefs: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        prefs = this.getSharedPreferences(PREFS_FILENAME, 0)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            val i = Intent(application, MainActivity::class.java)
            startActivity(i)
        }

        fragment1.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "f1")
            editor.apply()
        }

        fragment2.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "f2")
            editor.apply()
        }

        fragment3.setOnClickListener {
            val editor = prefs!!.edit()
            editor.putString(GO_FRAGMENT, "f3")
            editor.apply()
        }

    }
}
