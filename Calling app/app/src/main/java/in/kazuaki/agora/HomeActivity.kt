package `in`.kazuaki.agora

import android.content.Intent
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import `in`.kazuaki.agora.agora.media.AudioActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Disable dark mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        setContentView(R.layout.activity_home)
        // Change the status bar color
        val window: Window = window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = ContextCompat.getColor(this, R.color.white)

        // Find the videoButton and audioButton by their IDs
        val videoButton: Button = findViewById(R.id.videoButton)
        val audioButton: Button = findViewById(R.id.audioButton)

        // Set click listener for the videoButton
        videoButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Set click listener for the audioButton
        audioButton.setOnClickListener {
            val intent = Intent(this, AudioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
