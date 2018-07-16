package com.mydigicode.startask.utils.intent.builder

import android.content.Intent
import com.mydigicode.startask.utils.intent.OnStartIntentListener

class SendEmailIntentBuilder : IntentBuilder {

    private var type = MIME_TYPE_EMAIL

    private var emails: Array<String>? = null

    private var subject: String? = null

    private var text: String? = null

    private var chooserTitle: String? = null

    private var startListener: OnStartIntentListener? = null

    fun type(type: String): SendEmailIntentBuilder {
        this.type = type
        return this
    }

    fun toEmail(email: String): SendEmailIntentBuilder {
        return toEmails(arrayOf(email))
    }

    fun toEmails(emails: Array<String>): SendEmailIntentBuilder {
        this.emails = emails
        return this
    }

    fun subject(subject: String): SendEmailIntentBuilder {
        this.subject = subject
        return this
    }

    fun text(text: String): SendEmailIntentBuilder {
        this.text = text
        return this
    }

    fun chooserTitle(title: String): SendEmailIntentBuilder {
        this.chooserTitle = title
        return this
    }

    fun startListener(startListener: OnStartIntentListener): SendEmailIntentBuilder {
        this.startListener = startListener
        return this
    }

    override fun getStartListener(): OnStartIntentListener? {
        return startListener
    }

    override fun build(): Intent {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = type

        if (emails != null) {
            intent.putExtra(Intent.EXTRA_EMAIL, emails)
        }

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

        private const val MIME_TYPE_EMAIL = "message/rfc822"


    }

}