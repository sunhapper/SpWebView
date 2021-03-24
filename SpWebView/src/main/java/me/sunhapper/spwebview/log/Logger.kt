package me.sunhapper.spwebview.log

import android.util.Log

/**
 * Created by sunhapper on 2021/3/17 .
 */
class Logger {
    companion object {
        fun i(tag: String = "SpWebView", msg: String) {
            Log.i(tag, msg)
        }
    }
}