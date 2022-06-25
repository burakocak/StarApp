package com.example.starapp

import android.graphics.Color
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.starsdk.StarSdk
import com.example.starsdk.StarSizeType


class MainActivity : AppCompatActivity() {


    private lateinit var webView: WebView
    private lateinit var smallButton: Button
    private lateinit var bigButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpUi()
    }

    private fun setUpUi() {
        webView = findViewById(R.id.webView)
        smallButton = findViewById(R.id.smallStar)
        bigButton = findViewById(R.id.bigStar)
        webView.setImageUrl()
        smallButton.setOnClickListener {
            StarSdk.addStarInterface(StarSizeType.S) {
                if (it) showAlert()
            }
        }
        bigButton.setOnClickListener {
            StarSdk.addStarInterface(StarSizeType.B) {
                if (it) showAlert()
            }
        }
    }

    private fun showAlert() {
        runOnUiThread {
            if (!isFinishing) {
                AlertDialog.Builder(this@MainActivity)
                    .setTitle(getString(R.string.starAlertDialogTitle))
                    .setMessage(getString(R.string.starAlertDialogMessage))
                    .setCancelable(true)
                    .show()
            }
        }
    }

    private fun WebView.setImageUrl() {
        setBackgroundColor(Color.BLACK)
        settings.loadWithOverviewMode = true
        settings.useWideViewPort = true
        loadData(Constant.WEB_VIEW_DATA, Constant.WEB_VIEW_MIME_TYPE, null)
    }
}