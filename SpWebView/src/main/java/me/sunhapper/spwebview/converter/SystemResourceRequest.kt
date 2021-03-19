package me.sunhapper.spwebview.converter

import android.net.Uri
import com.tencent.smtt.export.external.interfaces.WebResourceRequest

/**
 * Created by sunhapper on 2020/5/22 .
 */
class SystemResourceRequest constructor(private val mWebResourceRequest: WebResourceRequest) :
    android.webkit.WebResourceRequest {
    override fun getUrl(): Uri {
        return mWebResourceRequest.url
    }

    override fun isForMainFrame(): Boolean {
        return mWebResourceRequest.isForMainFrame
    }

    override fun isRedirect(): Boolean {
        return mWebResourceRequest.isRedirect
    }

    override fun hasGesture(): Boolean {
        return mWebResourceRequest.hasGesture()
    }

    override fun getMethod(): String {
        return mWebResourceRequest.method
    }

    override fun getRequestHeaders(): Map<String, String> {
        return mWebResourceRequest.requestHeaders
    }

}