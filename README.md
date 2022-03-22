# OTP-view

#### Library size is : Kb
  
## Setup Project

Add this to your project build.gradle
``` gradle
allprojects {
    repositories {
        maven {
            url "https://jitpack.io"
        }
    }
}
```

Add this to your project build.gradle

#### Dependency
[![](https://jitpack.io/v/appsfeature/otp-view.svg)](https://jitpack.io/#appsfeature/otp-view)
```gradle
dependencies {
        implementation 'com.github.appsfeature:otp-view:1.0'
}
```


### OTP-view Usage methods

<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeature/otp-view/master/screenshots/screenshot_1.png" alt="Preview 1" width="200" />
</p>

### OTP Box implementation changes in layout.xml file
```xml
    <com.otpview.OTPTextView
        android:id="@+id/otp_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#ffffff"
        app:otp_box_background="@drawable/bg_otp_box"
        app:otp_box_background_active="@drawable/bg_otp_box_active"
        app:otp_box_background_inactive="@drawable/bg_otp_box_inactive"
        app:otp_box_background_error="@drawable/bg_otp_box_error"
        app:otp_box_background_success="@drawable/bg_otp_box_success"
        app:box_margin="0dp"
        app:height="40dp"
        app:hide_otp="false"
        app:length="6"
        app:otp=""
        app:otp_text_size="20dp"
        app:width="40dp" />
```

<p align="left">
  <img src="https://raw.githubusercontent.com/appsfeature/otp-view/master/screenshots/screenshot_2.png" alt="Preview 1" width="200" />
</p>

### Dash implementation changes in layout.xml file
```xml
    <com.otpview.OTPTextView
        android:id="@+id/otp_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="#ffffff"
        app:bar_active_color="@color/white"
        app:bar_enabled="true"
        app:bar_error_color="@color/red"
        app:bar_height="1.5dp"
        app:bar_inactive_color="#606060"
        app:bar_margin_bottom="0dp"
        app:bar_margin_left="2dp"
        app:bar_margin_right="2dp"
        app:bar_success_color="#33cc33"
        app:box_margin="0dp"
        app:height="40dp"
        app:hide_otp="true"
        app:length="6"
        app:otp=""
        app:otp_text_size="20dp"
        app:width="40dp" />
```

### Activity class setup
```java
class MainActivity : AppCompatActivity() {
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
```


