package me.sunhapper.spwebview.component

import android.webkit.WebView

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface HttpAuthHandlerComponent {
    fun useHttpAuthUsernamePassword(): Boolean
    fun cancel()
    fun proceed(username: String?, password: String?)
}