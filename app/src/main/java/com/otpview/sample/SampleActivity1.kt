package com.otpview.sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.otpview.OTPListener
import com.otpview.OTPTextView

class SampleActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample1)

        val errorButton = findViewById<Button>(R.id.button)
        val successButton = findViewById<Button>(R.id.button2)
        val otpTextView = findViewById(R.id.otp_view) as OTPTextView
        otpTextView.requestFocusOTP()
        otpTextView.otpListener = object : OTPListener {
            override fun onInteractionListener() {

            }

            override fun onOTPComplete(otp: String) {
                Toast.makeText(this@SampleActivity1, "The OTP is $otp", Toast.LENGTH_SHORT).show()
            }
        }
        errorButton.setOnClickListener { otpTextView.showError() }
        successButton.setOnClickListener { otpTextView.showSuccess() }
    }
}