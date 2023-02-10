# OTP View in Android

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

### Screenshots
<p align="left">
    <img src="https://raw.githubusercontent.com/appsfeature/otp-view/master/screenshots/screenshot_1.png" alt="Preview 1" width="250" />
    <img src="https://raw.githubusercontent.com/appsfeature/otp-view/master/screenshots/screenshot_2.png" alt="Preview 1" width="250" />
</p>

### OTP-view Usage methods

### OTP Box implementation changes in layout.xml file
```xml
    <com.otpview.OTPTextView
        android:id="@+id/otp_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@android:color/black"
        app:otp_text_size="20sp"
        app:otp_box_background="@drawable/bg_otp_box"
        app:otp_box_background_active="@drawable/bg_otp_box_active"
        app:otp_box_background_inactive="@drawable/bg_otp_box_inactive"
        app:otp_box_background_error="@drawable/bg_otp_box_error"
        app:otp_box_background_success="@drawable/bg_otp_box_success"
        app:hide_otp_drawable="@drawable/bg_otp_box_hide"
        app:height="45dp"
        app:width="40dp"
        app:box_margin="6dp"
        app:hide_otp="false"
        app:length="6"
        app:otp=""/>
```


### Dash View implementation changes in layout.xml file
```xml
    <com.otpview.OTPTextView
        android:id="@+id/otp_view"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@android:color/black"
        app:otp_text_size="20dp"
        app:bar_enabled="true"
        app:bar_error_color="@color/red"
        app:bar_active_color="@color/black"
        app:bar_inactive_color="@android:color/darker_gray"
        app:hide_otp_drawable="@drawable/bg_otp_box_hide"
        app:bar_success_color="#33cc33"
        app:bar_margin_bottom="0dp"
        app:bar_margin_left="2dp"
        app:bar_margin_right="2dp"
        app:bar_height="1.5dp"
        app:box_margin="0dp"
        app:height="40dp"
        app:width="40dp"
        app:hide_otp="true"
        app:length="4"
        app:otp=""/>
```

### Activity class setup
```java
class MainActivity : AppCompatActivity() {
     private lateinit var otpTextView : OTPTextView

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_sample1)

         val errorButton = findViewById<Button>(R.id.button)
         val successButton = findViewById<Button>(R.id.button2)
         otpTextView = findViewById(R.id.otp_view) as OTPTextView
         otpTextView.requestFocusOTP()
         otpTextView.otpListener = object : OTPListener {
             override fun onInteractionListener() {

             }

             override fun onOTPComplete(otp: String) {
                 Toast.makeText(this@MainActivity, "The OTP is $otp", Toast.LENGTH_SHORT).show()
             }
         }
         errorButton.setOnClickListener { otpTextView.showError() }
         successButton.setOnClickListener { otpTextView.showSuccess() }

         additionalMethods()
     }

     fun additionalMethods() {
         otpTextView.getOtpListener();  // retrieves the current OTPListener (null if nothing is set)
         otpTextView.requestFocusOTP();	//sets the focus to OTP box (does not open the keyboard)
         otpTextView.setOTP(otpString);	// sets the entered otpString in the Otp box (for case when otp is retrieved from SMS)
         otpTextView.getOTP();	// retrieves the OTP entered by user (works for partial otp input too)
         otpTextView.showSuccess();	// shows the success state to the user (can be set a bar color or drawable)
         otpTextView.showError();	// shows the success state to the user (can be set a bar color or drawable)
         otpTextView.resetState();	// brings the views back to default state (the state it was at input)
     }
 }
```

### Color Resources
```xml
    <color name="color_background_box">#F5F5F5</color>
    <color name="color_background_box_stroke">#DEDEDE</color>
    <color name="color_background_box_stroke_active">#A5A5A5</color>
```


