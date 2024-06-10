package com.example.webfasttechviewer

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the progress bar and web view
        progressBar = findViewById(R.id.progressBar)
        webView = findViewById(R.id.webview)

        // Set the WebViewClient to handle events in the WebView
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                progressBar.visibility = View.VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                progressBar.visibility = View.GONE
            }

            override fun onReceivedError(view: WebView?, request: WebResourceRequest?, error: WebResourceError?) {
                // Handle the error here, e.g., show a toast message
                // Toast.makeText(applicationContext, "Error loading page", Toast.LENGTH_SHORT).show()
                // Alternatively, you can load a different URL or reload the current URL
                // webView.loadUrl("https://example.com/error")
            }
        }

        // Enable JavaScript in the WebView settings
        val webSettings = webView.settings
        webSettings.javaScriptEnabled = true

        // Load the initial URL
        webView.loadUrl("https://webfasttech.com/")
    }
}
