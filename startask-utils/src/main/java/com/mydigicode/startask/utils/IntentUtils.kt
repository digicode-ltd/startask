package com.mydigicode.startask.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent

/* Email */
fun Context.sendEmail(to: String, subject: String, text: String, startListener: IntentUtils.OnStartListener) {
    sendEmail(arrayOf(to), subject, text, startListener)
}

fun Context.sendEmail(to: Array<String>, subject: String, text: String, startListener: IntentUtils.OnStartListener) {
    IntentUtils.startIntent(this, IntentUtils.newEmailIntent(to, subject, text), startListener)
}

/* Share */
fun Context.shareText(subject: String, message: String, chooserDialogTitle: String, startListener: IntentUtils.OnStartListener) {
    IntentUtils.startIntent(this, IntentUtils.newShareTextIntent(subject, message, chooserDialogTitle), startListener)
}

/* Browser */

/* Browser */

/* Video */

/* Audio */

/* Image */


class IntentUtils {

    companion object {

        private const val MIME_TYPE_EMAIL = "message/rfc822"
        private const val MIME_TYPE_TEXT = "text/*"

        fun newEmailIntent(to: Array<String>, subject: String, text: String): Intent {
            val intent = Intent(Intent.ACTION_SENDTO)
            intent.type = MIME_TYPE_EMAIL
            intent.putExtra(Intent.EXTRA_EMAIL, to)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            intent.putExtra(Intent.EXTRA_TEXT, text)
            return intent
        }

        fun newShareTextIntent(subject: String, message: String, chooserDialogTitle: String): Intent {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = MIME_TYPE_TEXT
            intent.putExtra(Intent.EXTRA_TEXT, message)
            intent.putExtra(Intent.EXTRA_SUBJECT, subject)
            return Intent.createChooser(intent, chooserDialogTitle)
        }

        fun startIntent(context: Context, intent: Intent, startListener: IntentUtils.OnStartListener) {
            try {
                context.startActivity(intent)

                startListener.onAppStarted()
            } catch (e: ActivityNotFoundException) {
                startListener.onAppNotFound()
            }
        }

    }

    interface OnStartListener {

        fun onAppNotFound()

        fun onAppStarted() {}

    }

}