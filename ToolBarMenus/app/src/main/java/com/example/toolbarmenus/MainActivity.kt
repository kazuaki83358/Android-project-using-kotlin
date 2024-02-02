package com.example.toolbarmenus

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.home -> Toast.makeText(this,"home",Toast.LENGTH_SHORT).show()
            R.id.add -> Toast.makeText(this,"add",Toast.LENGTH_SHORT).show()
            R.id.bookmark -> Toast.makeText(this,"bookmark",Toast.LENGTH_SHORT).show()
        }
        return true
    }
}