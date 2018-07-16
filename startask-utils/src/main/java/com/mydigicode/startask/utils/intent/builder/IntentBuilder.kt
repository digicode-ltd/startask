package com.mydigicode.startask.utils.intent.builder

import android.content.Intent
import com.mydigicode.startask.utils.intent.OnStartIntentListener

interface IntentBuilder {

    fun getStartListener(): OnStartIntentListener? {
        return null
    }

    fun build(): Intent

}