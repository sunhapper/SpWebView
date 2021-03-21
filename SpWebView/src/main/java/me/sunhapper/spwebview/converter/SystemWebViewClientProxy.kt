package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import androidx.annotation.RequiresApi
import me.sunhapper.spwebview.component.toComponent
import me.sunhapper.spwebview.component.toSystem

/**
 * Created by sunhapper on 2021/3/17 .
 */
class SystemWebViewClientProxy(
    private val webViewClientComponent: WebViewClientComponent<WebView>
) : WebViewClient() {
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        webViewClientComponent.onReceivedError(view, errorCode, description, failingUrl)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        webViewClientComponent.onReceivedError(view, request.toComponent(), error.toComponent())
    }

    override fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        webViewClientComponent.onReceivedHttpError(
            view,
            request.toComponent(),
            errorResponse.toComponent()
        )
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler?, error: SslError?) {
        webViewClientComponent.onReceivedSslError(view, handler.toComponent(), error.toComponent())
    }

    override fun onPageFinished(view: WebView, url: String?) {
        webViewClientComponent.onPageFinished(view, url)
    }

    override fun shouldInterceptRequest(view: WebView, url: String?): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, url).toSystem()
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, request.toComponent()).toSystem()
    }

    override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean {
        return webViewClientComponent.shouldOverrideKeyEvent(view, event)
    }

    override fun onSafeBrowsingHit(
        view: WebView,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?
    ) {
        webViewClientComponent.onSafeBrowsingHit(
            view,
            request.toComponent(),
            threatType,
            callback.toComponent()
        )
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        webViewClientComponent.doUpdateVisitedHistory(view, url, isReload)
    }

    override fun onRenderProcessGone(view: WebView, detail: RenderProcessGoneDetail?): Boolean {
        return webViewClientComponent.onRenderProcessGone(view, detail.toComponent())
    }

    override fun onReceivedLoginRequest(
        view: WebView,
        realm: String?,
        account: String?,
        args: String?
    ) {
        webViewClientComponent.onReceivedLoginRequest(view, realm, account, args)
    }

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        webViewClientComponent.onPageStarted(view, url, favicon)
    }

    override fun onScaleChanged(view: WebView, oldScale: Float, newScale: Float) {
        webViewClientComponent.onScaleChanged(view, oldScale, newScale)
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        return webViewClientComponent.shouldOverrideUrlLoading(view, url)
    }

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
        return webViewClientComponent.shouldOverrideUrlLoading(view, request.toComponent())
    }

    override fun onPageCommitVisible(view: WebView, url: String?) {
        webViewClientComponent.onPageCommitVisible(view, url)
    }

    override fun onUnhandledKeyEvent(view: WebView, event: KeyEvent?) {
        webViewClientComponent.onUnhandledKeyEvent(view, event)
    }

    override fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequest?) {
        webViewClientComponent.onReceivedClientCertRequest(view, request.toComponent())
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        webViewClientComponent.onReceivedHttpAuthRequest(view, handler.toComponent(), host, realm)
    }

    override fun onTooManyRedirects(view: WebView, cancelMsg: Message?, continueMsg: Message?) {
        webViewClientComponent.onTooManyRedirects(view, cancelMsg, continueMsg)
    }

    override fun onFormResubmission(view: WebView, dontResend: Message?, resend: Message?) {
        webViewClientComponent.onFormResubmission(view, dontResend, resend)
    }

    override fun onLoadResource(view: WebView, url: String?) {
        webViewClientComponent.onLoadResource(view, url)
    }


}