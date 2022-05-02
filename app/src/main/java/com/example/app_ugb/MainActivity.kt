package com.example.app_ugb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        web.webChromeClient = object : WebChromeClient(){

        }

        web.webViewClient=object : WebViewClient(){

        }
        val settings: WebSettings = web.settings
        settings.javaScriptEnabled=true

        web.loadUrl("https://www.ugb.edu.sv")
        btn1.setOnClickListener {
            oneFragment(unofragmento())
        }
        btn2.setOnClickListener {
            oneFragment(twoFragment())
        }
        btn3.setOnClickListener {
            oneFragment(tresFragment())
        }
    }
    private fun oneFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.master, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
}