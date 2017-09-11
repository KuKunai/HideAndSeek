package com.minipg.knot.hideseek

import android.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.minipg.knot.hideseek.adapters.PageAdapter
import com.minipg.knot.hideseek.fragment.FirstFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mSectionPageAdapter: PageAdapter? = null
    private var firstFragment: FirstFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = "Hello"
        setSupportActionBar(toolbar)
        mSectionPageAdapter = PageAdapter(supportFragmentManager,this)
        container.adapter = mSectionPageAdapter
        tabs.setupWithViewPager(container)

        tabs.getTabAt(0)?.text = "First"
        tabs.getTabAt(1)?.text = "Second"
        tabs.getTabAt(2)?.text = "Third"
//
//        supportFragmentManager.beginTransaction()
//                .replace(R.id.container,firstFragment)
//                .commit()
    }
}
