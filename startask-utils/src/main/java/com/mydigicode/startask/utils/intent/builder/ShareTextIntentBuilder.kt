package com.mydigicode.startask.utils.intent.builder

import android.content.Intent
import com.mydigicode.startask.utils.intent.OnStartIntentListener

class ShareTextIntentBuilder : IntentBuilder {

    private var type = MIME_TYPE_TEXT

    private var subject: String? = null

    private var text: String? = null

    private var chooserTitle: String? = null

    private var startListener: OnStartIntentListener? = null

    fun subject(subject: String): ShareTextIntentBuilder {
        this.subject = subject
        return this
    }

    fun text(text: String): ShareTextIntentBuilder {
        this.text = text
        return this
    }

    fun chooserTitle(title: String): ShareTextIntentBuilder {
        this.chooserTitle = title
        return this
    }

    fun startListener(startListener: OnStartIntentListener): ShareTextIntentBuilder {
        this.startListener = startListener
        return this
    }

    override fun getStartListener(): OnStartIntentListener? {
        return startListener
    }

    override fun build(): Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = type

        if (subject != null) {
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        }

        if (text != null) {
            intent.putExtra(Intent.EXTRA_TEXT, text)
        }

        return if (chooserTitle != null) {
            Intent.createChooser(intent, chooserTitle)
        } else {
            intent
        }
    }

    companion object {

        private const val MIME_TYPE_TEXT = "text/*"

    }

}