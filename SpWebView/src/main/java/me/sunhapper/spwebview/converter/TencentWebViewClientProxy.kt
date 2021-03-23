package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.os.Message
import android.view.KeyEvent
import androidx.annotation.RequiresApi
import com.tencent.smtt.export.external.interfaces.*
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import me.sunhapper.spwebview.component.WebViewClientComponent
import me.sunhapper.spwebview.component.toComponent
import me.sunhapper.spwebview.component.toX5

/**
 * Created by sunhapper on 2021/3/17 .
 */
class TencentWebViewClientProxy(
    private val webViewClientComponent: WebViewClientComponent<WebView>,
    private val webViewClient: WebViewClient?
) : WebViewClient() {
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        webViewClient?.onReceivedError(view, errorCode, description, failingUrl)
        webViewClientComponent.onReceivedError(view, errorCode, description, failingUrl)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        webViewClient?.onReceivedError(view, request, error)
        webViewClientComponent.onReceivedError(view, request.toComponent(), error.toComponent())
    }

    override fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            webViewClient?.onReceivedHttpError(view, request, errorResponse)
        }
        webViewClientComponent.onReceivedHttpError(
            view,
            request.toComponent(),
            errorResponse.toComponent()
        )
    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler?, error: SslError?) {
        webViewClient?.onReceivedSslError(view, handler, error)
        webViewClientComponent.onReceivedSslError(view, handler.toComponent(), error.toComponent())
    }

    override fun onPageFinished(view: WebView, url: String?) {
        webViewClient?.onPageFinished(view, url)
        webViewClientComponent.onPageFinished(view, url)
    }

    override fun shouldInterceptRequest(view: WebView, url: String?): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, url).toX5()
            ?: webViewClient?.shouldInterceptRequest(view, url)
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, request.toComponent()).toX5()
            ?: webViewClient?.shouldInterceptRequest(view, request)
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?,
        p2: Bundle?
    ): WebResourceResponse? {
        return webViewClientComponent.shouldInterceptRequest(view, request.toComponent()).toX5()
    }

    override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean {
        return webViewClient?.shouldOverrideKeyEvent(view, event) ?: super.shouldOverrideKeyEvent(
            view,
            event
        )
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        webViewClient?.doUpdateVisitedHistory(view, url, isReload)
    }


    override fun onReceivedLoginRequest(
        view: WebView,
        realm: String?,
        account: String?,
        args: String?
    ) {
        webViewClient?.onReceivedLoginRequest(view, realm, account, args)
    }

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        webViewClient?.onPageStarted(view, url, favicon)
        webViewClientComponent.onPageStarted(view, url, favicon)
    }

    override fun onScaleChanged(view: WebView, oldScale: Float, newScale: Float) {
        webViewClient?.onScaleChanged(view, oldScale, newScale)
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        return if (!webViewClientComponent.shouldOverrideUrlLoading(view, url)) {
            webViewClient?.shouldOverrideUrlLoading(view, url) ?: super.shouldOverrideUrlLoading(
                view,
                url
            )
        } else {
            false
        }
    }

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
        return if (!webViewClientComponent.shouldOverrideUrlLoading(view, request.toComponent())) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && webViewClient != null) {
                webViewClient.shouldOverrideUrlLoading(view, request)
            } else {
                super.shouldOverrideUrlLoading(
                    view,
                    request
                )
            }
        } else {
            false
        }
    }

    override fun onUnhandledKeyEvent(view: WebView, event: KeyEvent?) {
        webViewClient?.onUnhandledKeyEvent(view, event)
    }

    override fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequest?) {
        webViewClient?.onReceivedClientCertRequest(view, request)
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        webViewClient?.onReceivedHttpAuthRequest(view, handler, host, realm)
    }

    override fun onTooManyRedirects(view: WebView, cancelMsg: Message?, continueMsg: Message?) {
        webViewClient?.onTooManyRedirects(view, cancelMsg, continueMsg)
    }

    override fun onFormResubmission(view: WebView, dontResend: Message?, resend: Message?) {
        webViewClient?.onFormResubmission(view, dontResend, resend)
    }

    override fun onLoadResource(view: WebView, url: String?) {
        webViewClient?.onLoadResource(view, url)
    }

    override fun onDetectedBlankScreen(p0: String?, p1: Int) {
        webViewClient?.onDetectedBlankScreen(p0, p1)
    }
}