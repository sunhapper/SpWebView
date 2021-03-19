package me.sunhapper.spwebview.ui.tencent

import android.graphics.Bitmap
import android.os.Bundle
import android.os.Message
import android.view.KeyEvent
import com.tencent.smtt.export.external.interfaces.*
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient

/**
 * Created by sunhapper on 2021/3/18 .
 */
class X5WebViewClient : WebViewClient() {
    override fun onPageFinished(p0: WebView?, p1: String?) {
        super.onPageFinished(p0, p1)
    }

    override fun shouldInterceptRequest(p0: WebView?, p1: String?): WebResourceResponse {
        return super.shouldInterceptRequest(p0, p1)
    }

    override fun shouldInterceptRequest(
        p0: WebView?,
        p1: WebResourceRequest?
    ): WebResourceResponse {
        return super.shouldInterceptRequest(p0, p1)
    }

    override fun shouldInterceptRequest(
        p0: WebView?,
        p1: WebResourceRequest?,
        p2: Bundle?
    ): WebResourceResponse {
        return super.shouldInterceptRequest(p0, p1, p2)
    }

    override fun shouldOverrideKeyEvent(p0: WebView?, p1: KeyEvent?): Boolean {
        return super.shouldOverrideKeyEvent(p0, p1)
    }

    override fun doUpdateVisitedHistory(p0: WebView?, p1: String?, p2: Boolean) {
        super.doUpdateVisitedHistory(p0, p1, p2)
    }

    override fun onReceivedError(p0: WebView?, p1: Int, p2: String?, p3: String?) {
        super.onReceivedError(p0, p1, p2, p3)
    }

    override fun onReceivedError(p0: WebView?, p1: WebResourceRequest?, p2: WebResourceError?) {
        super.onReceivedError(p0, p1, p2)
    }

    override fun onReceivedLoginRequest(p0: WebView?, p1: String?, p2: String?, p3: String?) {
        super.onReceivedLoginRequest(p0, p1, p2, p3)
    }

    override fun onReceivedHttpError(
        p0: WebView?,
        p1: WebResourceRequest?,
        p2: WebResourceResponse?
    ) {
        super.onReceivedHttpError(p0, p1, p2)
    }

    override fun onPageStarted(p0: WebView?, p1: String?, p2: Bitmap?) {
        super.onPageStarted(p0, p1, p2)
    }

    override fun onScaleChanged(p0: WebView?, p1: Float, p2: Float) {
        super.onScaleChanged(p0, p1, p2)
    }

    override fun shouldOverrideUrlLoading(p0: WebView?, p1: String?): Boolean {
        return super.shouldOverrideUrlLoading(p0, p1)
    }

    override fun shouldOverrideUrlLoading(p0: WebView?, p1: WebResourceRequest?): Boolean {
        return super.shouldOverrideUrlLoading(p0, p1)
    }

    override fun onUnhandledKeyEvent(p0: WebView?, p1: KeyEvent?) {
        super.onUnhandledKeyEvent(p0, p1)
    }

    override fun onReceivedHttpAuthRequest(
        p0: WebView?,
        p1: HttpAuthHandler?,
        p2: String?,
        p3: String?
    ) {
        super.onReceivedHttpAuthRequest(p0, p1, p2, p3)
    }

    override fun onReceivedClientCertRequest(p0: WebView?, p1: ClientCertRequest?) {
        super.onReceivedClientCertRequest(p0, p1)
    }

    override fun onReceivedSslError(p0: WebView?, p1: SslErrorHandler?, p2: SslError?) {
        super.onReceivedSslError(p0, p1, p2)
    }

    override fun onTooManyRedirects(p0: WebView?, p1: Message?, p2: Message?) {
        super.onTooManyRedirects(p0, p1, p2)
    }

    override fun onFormResubmission(p0: WebView?, p1: Message?, p2: Message?) {
        super.onFormResubmission(p0, p1, p2)
    }

    override fun onDetectedBlankScreen(p0: String?, p1: Int) {
        super.onDetectedBlankScreen(p0, p1)
    }

    override fun onLoadResource(p0: WebView?, p1: String?) {
        super.onLoadResource(p0, p1)
    }
}