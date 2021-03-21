package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.webkit.ClientCertRequest
import android.webkit.HttpAuthHandler
import android.webkit.RenderProcessGoneDetail
import android.webkit.SslErrorHandler
import me.sunhapper.spwebview.component.*

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface WebViewClientComponent<WebView : View> {
    fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    )

    fun onReceivedError(
        view: WebView,
        request: WebResourceRequestComponent?,
        error: WebResourceErrorComponent?
    )

    fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequestComponent?,
        errorResponse: WebResourceResponseComponent?
    )

    fun onLoadResource(view: WebView, url: String?)
    fun onReceivedSslError(view: WebView, handler: SslErrorHandlerComponent?, error: SslErrorComponent?)
    fun onPageFinished(webView: WebView, url: String?)
    fun shouldInterceptRequest(webView: WebView, url: String?): WebResourceResponseComponent?
    fun shouldInterceptRequest(
        webView: WebView,
        request: WebResourceRequestComponent?
    ): WebResourceResponseComponent?

    fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean
    fun onSafeBrowsingHit(
        view: WebView,
        request: WebResourceRequestComponent?,
        threatType: Int,
        callback: SafeBrowsingResponseComponent?
    )

    fun doUpdateVisitedHistory(view: WebView, url: String?, reload: Boolean)
    fun onRenderProcessGone(view: WebView, detail: RenderProcessGoneDetailComponent?): Boolean
    abstract fun onReceivedLoginRequest(view: WebView, realm: String?, account: String?, args: String?)
    fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?)
    fun onScaleChanged(view: WebView, oldScale: Float, newScale: Float)
    fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean
    fun shouldOverrideUrlLoading(view: WebView,  request: WebResourceRequestComponent?): Boolean
    fun onPageCommitVisible(view: WebView, url: String?)
    fun onUnhandledKeyEvent(view: WebView, event: KeyEvent?)
    fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequestComponent?)
    fun onFormResubmission(view: WebView, dontResend: Message?, resend: Message?)
    fun onTooManyRedirects(view: WebView, cancelMsg: Message?, continueMsg: Message?)
    fun onReceivedHttpAuthRequest(
        view: WebView,
        handler: HttpAuthHandlerComponent?,
        host: String?,
        realm: String?
    )

    /**
     * only validate in x5
     */
    fun onDetectedBlankScreen(p0: String?, p1: Int)


}