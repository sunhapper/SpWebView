package me.sunhapper.spwebview.tool

import android.util.Log

/**
 * Created by sunhapper on 2021/3/25 .
 */
class Logger {
    companion object {
        fun i(tag: String, message: String) {
            Log.i(tag, message);
        }
    }
}