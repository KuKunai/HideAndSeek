package com.minipg.knot.hideseek.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.minipg.knot.hideseek.AnimetionDialog
import com.minipg.knot.hideseek.R
import kotlinx.android.synthetic.main.fragment_one.*
import kotlinx.android.synthetic.main.mascot.*

/**
 * Created by Knot on 9/8/2017.
 */
class ThirdFragment() : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_three, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val GG = AnimetionDialog(btnGG_One, context, svOutside)
        GG.initinstance()
    }
}