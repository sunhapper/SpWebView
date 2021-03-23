package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import me.sunhapper.spwebview.component.WebViewClientComponent
import me.sunhapper.spwebview.component.toComponent
import me.sunhapper.spwebview.component.toSystem
import me.sunhapper.spwebview.config.SpWebViewConfig

/**
 * Created by sunhapper on 2021/3/17 .
 */
class SystemWebViewClientProxy(
    private val webViewClientComponent: WebViewClientComponent<WebView>,
    private val webViewClient: WebViewClient?,
    private val spWebViewConfig: SpWebViewConfig
) : WebViewClient() {
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    ) {
        if (spWebViewConfig.needSpErrorPage) {
            webViewClientComponent.onReceivedError(view, errorCode, description, failingUrl)
        }
        webViewClient?.onReceivedError(view, errorCode, description, failingUrl)
            ?: super.onReceivedError(view, errorCode, description, failingUrl)
    }

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        if (spWebViewConfig.needSpErrorPage) {
            webViewClientComponent.onReceivedError(view, request.toComponent(), error.toComponent())
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && webViewClient != null) {
            webViewClient.onReceivedError(view, request, error)
        } else {
            super.onReceivedError(
                view,
                request,
                error
            )
        }
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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            webViewClient?.onReceivedHttpError(view, request, errorResponse)
        }

    }

    override fun onReceivedSslError(view: WebView, handler: SslErrorHandler?, error: SslError?) {
        if (spWebViewConfig.needSpErrorPage) {
            webViewClientComponent.onReceivedSslError(
                view,
                handler.toComponent(),
                error.toComponent()
            )
        }
        webViewClient?.onReceivedSslError(view, handler, error)
            ?: super.onReceivedSslError(view, handler, error)
    }

    override fun onPageFinished(view: WebView, url: String?) {
        webViewClient?.onPageFinished(view, url)
        webViewClientComponent.onPageFinished(view, url)
    }

    override fun shouldInterceptRequest(view: WebView, url: String?): WebResourceResponse? {
        return if (spWebViewConfig.needSpInterceptRequest) {
            webViewClientComponent.shouldInterceptRequest(view, url).toSystem()
                ?: webViewClient?.shouldInterceptRequest(view, url) ?: super.shouldInterceptRequest(
                    view,
                    url
                )
        } else {
            webViewClient?.shouldInterceptRequest(view, url) ?: super.shouldInterceptRequest(
                view,
                url
            )
        }
    }

    override fun shouldInterceptRequest(
        view: WebView,
        request: WebResourceRequest?
    ): WebResourceResponse? {
        return if (spWebViewConfig.needSpInterceptRequest) {
            webViewClientComponent.shouldInterceptRequest(view, request.toComponent())
                .toSystem()
                ?: webViewClient?.shouldInterceptRequest(view, request)
                ?: super.shouldInterceptRequest(view, request)
        } else {
            webViewClient?.shouldInterceptRequest(view, request)
                ?: super.shouldInterceptRequest(view, request)
        }
    }

    override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean {
        return webViewClient?.shouldOverrideKeyEvent(view, event) ?: super.shouldOverrideKeyEvent(
            view,
            event
        )
    }

    override fun onSafeBrowsingHit(
        view: WebView,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?
    ) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1 && webViewClient != null) {
            webViewClient.onSafeBrowsingHit(view, request, threatType, callback)
        } else {
            super.onSafeBrowsingHit(view, request, threatType, callback)
        }
    }

    override fun doUpdateVisitedHistory(view: WebView, url: String?, isReload: Boolean) {
        if (webViewClient != null) {
            webViewClient.doUpdateVisitedHistory(view, url, isReload)
        } else {
            super.doUpdateVisitedHistory(view, url, isReload)
        }
    }

    override fun onRenderProcessGone(view: WebView, detail: RenderProcessGoneDetail?): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O && webViewClient != null) {
            webViewClient.onRenderProcessGone(view, detail)
        } else {
            super.onRenderProcessGone(
                view,
                detail
            )
        }
    }

    override fun onReceivedLoginRequest(
        view: WebView,
        realm: String?,
        account: String?,
        args: String?
    ) {
        if (webViewClient != null) {
            webViewClient.onReceivedLoginRequest(view, realm, account, args)
        } else {
            super.onReceivedLoginRequest(view, realm, account, args)
        }
    }

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        webViewClientComponent.onPageStarted(view, url, favicon)
        if (webViewClient != null) {
            webViewClient.onPageStarted(view, url, favicon)
        } else {
            super.onPageStarted(view, url, favicon)
        }
    }

    override fun onScaleChanged(view: WebView, oldScale: Float, newScale: Float) {
        if (webViewClient != null) {
            webViewClient.onScaleChanged(view, oldScale, newScale)
        } else {
            super.onScaleChanged(view, oldScale, newScale)
        }
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        return if (spWebViewConfig.needSpOverrideUrl
            && webViewClientComponent.shouldOverrideUrlLoading(view, url)
        ) {
            true
        } else {
            webViewClient?.shouldOverrideUrlLoading(view, url)
                ?: super.shouldOverrideUrlLoading(
                    view,
                    url
                )
        }
    }

    override fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequest?): Boolean {
        return if (spWebViewConfig.needSpOverrideUrl
            && webViewClientComponent.shouldOverrideUrlLoading(view, request.toComponent())
        ) {
            true
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N && webViewClient != null) {
                webViewClient.shouldOverrideUrlLoading(view, request)
            } else {
                super.shouldOverrideUrlLoading(
                    view,
                    request
                )
            }
        }
    }

    override fun onPageCommitVisible(view: WebView, url: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && webViewClient != null) {
            webViewClient.onPageCommitVisible(view, url)
        } else {
            super.onPageCommitVisible(view, url)
        }
    }

    override fun onUnhandledKeyEvent(view: WebView, event: KeyEvent?) {
        if (webViewClient != null) {
            webViewClient.onUnhandledKeyEvent(view, event)
        } else {
            super.onUnhandledKeyEvent(view, event)
        }

    }

    override fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequest?) {
        if (webViewClient != null) {
            webViewClient.onReceivedClientCertRequest(view, request)
        } else {
            super.onReceivedClientCertRequest(view, request)
        }
    }

    override fun onReceivedHttpAuthRequest(
        view: WebView,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    ) {
        if (webViewClient != null) {
            webViewClient.onReceivedHttpAuthRequest(view, handler, host, realm)
        } else {
            super.onReceivedHttpAuthRequest(view, handler, host, realm)
        }
    }

    override fun onTooManyRedirects(view: WebView, cancelMsg: Message?, continueMsg: Message?) {
        if (webViewClient != null) {
            webViewClient.onTooManyRedirects(view, cancelMsg, continueMsg)
        } else {
            super.onTooManyRedirects(view, cancelMsg, continueMsg)
        }
    }

    override fun onFormResubmission(view: WebView, dontResend: Message?, resend: Message?) {
        if (webViewClient != null) {
            webViewClient.onFormResubmission(view, dontResend, resend)
        } else {
            super.onFormResubmission(view, dontResend, resend)
        }
    }

    override fun onLoadResource(view: WebView, url: String?) {
        if (webViewClient != null) {
            webViewClient.onLoadResource(view, url)
        } else {
            super.onLoadResource(view, url)
        }
    }
}