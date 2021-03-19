package me.sunhapper.spwebview.ui.system

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*

/**
 * Created by sunhapper on 2021/3/17 .
 */
class SystemWebViewClient : WebViewClient() {
    var webViewClientInterface: WebViewClientInterface? = null
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        webViewClientInterface?.onReceivedError(view, errorCode, description, failingUrl)
            ?: super.onReceivedError(view, errorCode, description, failingUrl)
    }

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        webViewClientInterface?.onReceivedError(view, request, error)
            ?: super.onReceivedError(view, request, error)
    }

    override fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        webViewClientInterface?.onReceivedHttpError(view, request, errorResponse)
            ?: super.onReceivedHttpError(view, request, errorResponse)
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler?, error: SslError?) {
        webViewClientInterface?.onReceivedSslError(view, handler, error)
            ?: super.onReceivedSslError(view, handler, error)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        webViewClientInterface?.onPageFinished(view, url) ?: super.onPageFinished(view, url)
    }

    override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
        return webViewClientInterface?.shouldInterceptRequest(view, url)
            ?: super.shouldInterceptRequest(view, url)
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return webViewClientInterface?.shouldInterceptRequest(view, request)
            ?: super.shouldInterceptRequest(view, request)
    }

    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return webViewClientInterface?.shouldOverrideKeyEvent(view, event)
            ?: super.shouldOverrideKeyEvent(view, event)
    }

    override fun onSafeBrowsingHit(
        view: WebView?,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?
    ) {
        webViewClientInterface?.onSafeBrowsingHit(view, request, threatType, callback)
            ?: super.onSafeBrowsingHit(view, request, threatType, callback)
    }

    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
        webViewClientInterface?.doUpdateVisitedHistory(view, url, isReload)
            ?: super.doUpdateVisitedHistory(view, url, isReload)
    }

    override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?): Boolean {
        return webViewClientInterface?.onRenderProcessGone(view, detail)
            ?: super.onRenderProcessGone(view, detail)
    }

    override fun onReceivedLoginRequest(
        view: WebView?,
        realm: String?,
        account: String?,
        args: String?
    ) {
        webViewClientInterface?.onReceivedLoginRequest(view, realm, account, args)
            ?: super.onReceivedLoginRequest(view, realm, account, args)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        webViewClientInterface?.onPageStarted(view, url, favicon)
            ?: super.onPageStarted(view, url, favicon)
    }

    override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
        webViewClientInterface?.onScaleChanged(view, oldScale, newScale)
            ?: super.onScaleChanged(view, oldScale, newScale)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return webViewClientInterface?.shouldOverrideUrlLoading(view, url)
            ?: super.shouldOverrideUrlLoading(view, url)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return webViewClientInterface?.shouldOverrideUrlLoading(view, request)
            ?: super.shouldOverrideUrlLoading(view, request)
    }

    override fun onPageCommitVisible(view: WebView?, url: String?) {
        webViewClientInterface?.onPageCommitVisible(view, url)
            ?: super.onPageCommitVisible(view, url)
    }

    override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
        webViewClientInterface?.onUnhandledKeyEvent(view, event)
            ?: super.onUnhandledKeyEvent(view, event)
    }

    override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
        webViewClientInterface?.onReceivedClientCertRequest(view, request)
            ?: super.onReceivedClientCertRequest(view, request)
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView?,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        webViewClientInterface?.onReceivedHttpAuthRequest(view, handler, host, realm)
            ?: super.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    override fun onTooManyRedirects(view: WebView?, cancelMsg: Message?, continueMsg: Message?) {
        webViewClientInterface?.onTooManyRedirects(view, cancelMsg, continueMsg)
            ?: super.onTooManyRedirects(view, cancelMsg, continueMsg)
    }

    override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
        webViewClientInterface?.onFormResubmission(view, dontResend, resend)
            ?: super.onFormResubmission(view, dontResend, resend)
    }

    override fun onLoadResource(view: WebView?, url: String?) {
        webViewClientInterface?.onLoadResource(view, url)
            ?: super.onLoadResource(view, url)
    }
}