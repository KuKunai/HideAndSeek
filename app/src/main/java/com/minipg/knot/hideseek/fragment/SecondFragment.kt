package com.minipg.knot.hideseek.fragment

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.minipg.knot.hideseek.AnimetionDialog
import com.minipg.knot.hideseek.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.mascot.*

/**
 * Created by Knot on 9/8/2017.
 */
class SecondFragment() : Fragment() {

    val PREFS_FILENAME = "plengslowtoad"
    val GO_FRAGMENT = "goFragment"
    var prefs: SharedPreferences? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_two, container, false)
    }
    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        prefs = activity.getSharedPreferences(PREFS_FILENAME, 0)
        val fragShow = prefs!!.getString(GO_FRAGMENT,"defaultValue")
        if(fragShow.equals("2")){
            val GG = AnimetionDialog(btnGG_One, context, svOutside)
            GG.initinstance()
        }
        else {
            Toast.makeText(activity, fragShow, Toast.LENGTH_SHORT).show()
        }
    }
}