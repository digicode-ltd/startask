package com.mydigicode.startask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mydigicode.startask.utils.intent.IntentUtils
import com.mydigicode.startask.utils.intent.OnStartIntentListener
import com.mydigicode.startask.utils.intent.start
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        share_btn.setOnClickListener {

            val intentBuilder = IntentUtils.getSharingBuilder()
                    .text("Text")
                    .subject("Subject")
                    .chooserTitle("Dialog title")

            IntentUtils.start(this, intentBuilder)

        }


        email_btn.setOnClickListener {

            val content = this

            val startIntentListener = object : OnStartIntentListener {
                override fun onAppNotFound() {
                    Toast.makeText(content, "Not Found!", Toast.LENGTH_SHORT).show()
                }
            }

            val intentBuilder = IntentUtils.getEmailBuilder()
                    .toEmail("ctanok@gmail.com")
                    .subject("Subject")
                    .text("text")
                    .startListener(startIntentListener)

            start(intentBuilder)

        }
    }

}
