package com.eliseche.androidseed.views

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.eliseche.androidseed.R
import com.eliseche.androidseed.viewmodels.ViewModelHome
import com.eliseche.androidseed.views.fragment.Fragment1
import com.eliseche.androidseed.views.fragment.Fragment2
import com.eliseche.androidseed.views.fragment.Fragment3
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Main entry point of App, it holds view with 3 fragments
 */
class ActivityHome : AppCompatActivity() {
    private lateinit var viewModelHome: ViewModelHome

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        loadFragment(item.itemId)

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelHome = ViewModelProviders.of(this).get(ViewModelHome::class.java)

        setContentView(R.layout.activity_home)

        init()
    }

    //region Setup
    private fun init() {
        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_fragment1
    }
    //endregion

    private fun loadFragment(itemId: Int) {
        val tag = itemId.toString()
        val fragment = supportFragmentManager.findFragmentByTag(tag) ?: when (itemId) {
            R.id.navigation_fragment1 -> Fragment1()
            R.id.navigation_fragment2 -> Fragment2()
            R.id.navigation_fragment3 -> Fragment3()
            else -> null
        }

        // show/hide fragment
        fragment?.let { fragmentNew ->
            val transaction = supportFragmentManager.beginTransaction()

            viewModelHome.lastActiveFragmentTag?.let { fragmentTag ->
                val lastFragment = supportFragmentManager.findFragmentByTag(fragmentTag)
                lastFragment?.let { fragmentOld ->
                    transaction.hide(fragmentOld)
                }
            }

            if (!fragmentNew.isAdded)
                transaction.add(R.id.content, fragmentNew, tag)
            else
                transaction.show(fragmentNew)

            transaction.commit()
            viewModelHome.lastActiveFragmentTag = tag
        }
    }
}