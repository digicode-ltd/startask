package com.mydigicode.startask.utils.intent

import android.content.ActivityNotFoundException
import android.content.Context
import com.mydigicode.startask.utils.intent.builder.IntentBuilder
import com.mydigicode.startask.utils.intent.builder.SendEmailIntentBuilder
import com.mydigicode.startask.utils.intent.builder.ShareTextIntentBuilder

fun Context.start(intentBuilder: IntentBuilder) {
    IntentUtils.start(this, intentBuilder)
}

class IntentUtils {

    companion object {

        fun getEmailBuilder(): SendEmailIntentBuilder {
            return SendEmailIntentBuilder()
        }

        fun getSharingBuilder(): ShareTextIntentBuilder {
            return ShareTextIntentBuilder()
        }

        fun start(context: Context, intentBuilder: IntentBuilder) {
            try {
                context.startActivity(intentBuilder.build())
                intentBuilder.getStartListener()?.onAppStarted()
            } catch (e: ActivityNotFoundException) {
                intentBuilder.getStartListener()?.onAppNotFound()
            }
        }

    }

}

interface OnStartIntentListener {

    fun onAppNotFound()

    fun onAppStarted() {}

}