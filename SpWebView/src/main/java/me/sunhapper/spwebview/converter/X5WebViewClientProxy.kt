package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.KeyEvent
import com.tencent.smtt.export.external.interfaces.*
import androidx.annotation.RequiresApi
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import me.sunhapper.spwebview.component.toComponent
import me.sunhapper.spwebview.component.toX5

/**
 * Created by sunhapper on 2021/3/17 .
 */
class X5WebViewClientProxy(
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
        return webViewClientComponent.shouldInterceptRequest(view, url).toX5()
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, request.toComponent()).toX5()
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?,
        p2: Bundle?
    ): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, request.toComponent()).toX5()
    }

    override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean {
        return webViewClientComponent.shouldOverrideKeyEvent(view, event)
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        webViewClientComponent.doUpdateVisitedHistory(view, url, isReload)
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

    override fun onDetectedBlankScreen(p0: String?, p1: Int) {
        webViewClientComponent.onDetectedBlankScreen(p0, p1)
    }
}