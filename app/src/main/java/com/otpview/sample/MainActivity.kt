package com.otpview.sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onSampleOne(view: View) {
        startActivity(Intent(this, SampleActivity1::class.java))
    }

    fun onSampleTwo(view: View) {
        startActivity(Intent(this, SampleActivity2::class.java))
    }
}