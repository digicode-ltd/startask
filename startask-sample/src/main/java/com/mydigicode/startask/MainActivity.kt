package com.mydigicode.startask

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mydigicode.startask.utils.IntentUtils
import com.mydigicode.startask.utils.sendEmail
import com.mydigicode.startask.utils.shareText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        share_btn.setOnClickListener {

            val callback = object : IntentUtils.OnStartListener {

                override fun onAppNotFound() {

                }

            }

            shareText("Subject", "Message", "Dialog Title", callback)


        }


        email_btn.setOnClickListener {

            val callback = object : IntentUtils.OnStartListener {

                override fun onAppNotFound() {

                }

            }

            sendEmail("ctanok@gmail.com", "subject", "Message", callback)

        }
    }

}
