package me.sunhapper.spwebview.component

import android.net.Uri

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface WebResourceRequestComponent {
    fun getUrl(): Uri?
    fun isForMainFrame(): Boolean
    fun isRedirect(): Boolean
    fun hasGesture(): Boolean
    fun getMethod(): String?
    fun getRequestHeaders(): Map<String, String>?
}