package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.webkit.*

/**
 * Created by sunhapper on 2021/3/17 .
 */
class SystemWebViewClientProxy(
    val x5WebViewClient: com.tencent.smtt.sdk.WebViewClient,
    val webView: com.tencent.smtt.sdk.WebView
) : WebViewClient() {
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        x5WebViewClient.onReceivedError(webView, errorCode, description, failingUrl)
    }

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        x5WebViewClient.onReceivedError(webView, request.toX5(), error)
    }

    override fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        webViewClientInterface?.onReceivedHttpError(webView, request, errorResponse)
            ?: super.onReceivedHttpError(webView, request, errorResponse)
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler?, error: SslError?) {
        webViewClientInterface?.onReceivedSslError(webView, handler, error)
            ?: super.onReceivedSslError(webView, handler, error)
    }

    override fun onPageFinished(view: WebView?, url: String?) {
        webViewClientInterface?.onPageFinished(webView, url) ?: super.onPageFinished(webView, url)
    }

    override fun shouldInterceptRequest(view: WebView?, url: String?): WebResourceResponse? {
        return webViewClientInterface?.shouldInterceptRequest(webView, url)
            ?: super.shouldInterceptRequest(webView, url)
    }

    override fun shouldInterceptRequest(
        view: WebView?,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return webViewClientInterface?.shouldInterceptRequest(webView, request)
            ?: super.shouldInterceptRequest(webView, request)
    }

    override fun shouldOverrideKeyEvent(view: WebView?, event: KeyEvent?): Boolean {
        return webViewClientInterface?.shouldOverrideKeyEvent(webView, event)
            ?: super.shouldOverrideKeyEvent(webView, event)
    }

    override fun onSafeBrowsingHit(
        view: WebView?,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?
    ) {
        webViewClientInterface?.onSafeBrowsingHit(webView, request, threatType, callback)
            ?: super.onSafeBrowsingHit(webView, request, threatType, callback)
    }

    override fun doUpdateVisitedHistory(view: WebView?, url: String?, isReload: Boolean) {
        webViewClientInterface?.doUpdateVisitedHistory(webView, url, isReload)
            ?: super.doUpdateVisitedHistory(webView, url, isReload)
    }

    override fun onRenderProcessGone(view: WebView?, detail: RenderProcessGoneDetail?): Boolean {
        return webViewClientInterface?.onRenderProcessGone(webView, detail)
            ?: super.onRenderProcessGone(webView, detail)
    }

    override fun onReceivedLoginRequest(
        view: WebView?,
        realm: String?,
        account: String?,
        args: String?
    ) {
        webViewClientInterface?.onReceivedLoginRequest(webView, realm, account, args)
            ?: super.onReceivedLoginRequest(webView, realm, account, args)
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        webViewClientInterface?.onPageStarted(webView, url, favicon)
            ?: super.onPageStarted(webView, url, favicon)
    }

    override fun onScaleChanged(view: WebView?, oldScale: Float, newScale: Float) {
        webViewClientInterface?.onScaleChanged(webView, oldScale, newScale)
            ?: super.onScaleChanged(webView, oldScale, newScale)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return webViewClientInterface?.shouldOverrideUrlLoading(webView, url)
            ?: super.shouldOverrideUrlLoading(webView, url)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        return webViewClientInterface?.shouldOverrideUrlLoading(webView, request)
            ?: super.shouldOverrideUrlLoading(webView, request)
    }

    override fun onPageCommitVisible(view: WebView?, url: String?) {
        webViewClientInterface?.onPageCommitVisible(webView, url)
            ?: super.onPageCommitVisible(webView, url)
    }

    override fun onUnhandledKeyEvent(view: WebView?, event: KeyEvent?) {
        webViewClientInterface?.onUnhandledKeyEvent(webView, event)
            ?: super.onUnhandledKeyEvent(webView, event)
    }

    override fun onReceivedClientCertRequest(view: WebView?, request: ClientCertRequest?) {
        webViewClientInterface?.onReceivedClientCertRequest(webView, request)
            ?: super.onReceivedClientCertRequest(webView, request)
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView?,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        webViewClientInterface?.onReceivedHttpAuthRequest(webView, handler, host, realm)
            ?: super.onReceivedHttpAuthRequest(webView, handler, host, realm)
    }

    override fun onTooManyRedirects(view: WebView?, cancelMsg: Message?, continueMsg: Message?) {
        webViewClientInterface?.onTooManyRedirects(webView, cancelMsg, continueMsg)
            ?: super.onTooManyRedirects(webView, cancelMsg, continueMsg)
    }

    override fun onFormResubmission(view: WebView?, dontResend: Message?, resend: Message?) {
        webViewClientInterface?.onFormResubmission(webView, dontResend, resend)
            ?: super.onFormResubmission(webView, dontResend, resend)
    }

    override fun onLoadResource(view: WebView?, url: String?) {
        webViewClientInterface?.onLoadResource(webView, url)
            ?: super.onLoadResource(webView, url)
    }
}