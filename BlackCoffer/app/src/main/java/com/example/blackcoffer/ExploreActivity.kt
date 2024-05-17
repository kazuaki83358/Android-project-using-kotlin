package com.example.blackcoffer

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ExploreActivity : AppCompatActivity() {

    private val TAG = "ExploreActivity"
    //i am just designing ui if i had data that i had use that in recycle view to to represent in fragments
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val iconDrawerToggle = findViewById<ImageView>(R.id.icon_drawer_toggle)
        val iconRefine = findViewById<ImageView>(R.id.icon_refine)
        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = findViewById<ViewPager2>(R.id.view_pager2)

        setSupportActionBar(toolbar)
        supportActionBar?.title = ""

        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        iconDrawerToggle.setOnClickListener {
            Log.d(TAG, "Drawer toggle icon clicked")
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        iconRefine.setOnClickListener {
            Log.d(TAG, "Refine icon clicked")
            Intent(this, RefineActivity::class.java).also {
                startActivity(it)
            }
        }

        val pagerAdapter = MyStateAdapter(this)
        viewPager.adapter = pagerAdapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
    }
}
