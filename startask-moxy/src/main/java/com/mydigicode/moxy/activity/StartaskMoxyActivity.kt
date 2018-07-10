package com.mydigicode.moxy.activity

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity

abstract class StartaskMoxyActivity : MvpAppCompatActivity() {

    abstract fun getLayoutId(): Int

    abstract fun getActivityTag(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutId = getLayoutId()
        if (layoutId != CUSTOM_LAYOUT_ID) {
            setContentView(getLayoutId())
        }

    }

    companion object {

        const val CUSTOM_LAYOUT_ID = -1

    }

}