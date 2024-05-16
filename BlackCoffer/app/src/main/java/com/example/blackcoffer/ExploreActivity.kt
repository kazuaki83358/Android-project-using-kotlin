package com.example.blackcoffer
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class ExploreActivity : AppCompatActivity() {

    private val TAG = "ExploreActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore)

        // Retrieve the custom ActionBar layout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val iconDrawerToggle = findViewById<ImageView>(R.id.icon_drawer_toggle)
        val iconRefine = findViewById<ImageView>(R.id.icon_refine)

        // Set it as the support ActionBar
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        // Find the DrawerLayout
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)

        // Handle click events for icons in the custom ActionBar
        iconDrawerToggle.setOnClickListener {
            Log.d(TAG, "Drawer toggle icon clicked")
            // Check if DrawerLayout is not null before opening the drawer
            drawerLayout?.openDrawer(GravityCompat.START)
        }

        iconRefine.setOnClickListener {
            Log.d(TAG, "Refine icon clicked")
            // Handle refine icon click here
            // For example, show refine options
            // showRefineOptions()
        }
    }
}
