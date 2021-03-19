package me.sunhapper.spwebview.ui.system

import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Message
import android.view.KeyEvent
import android.view.View
import android.webkit.*

/**
 * Created by sunhapper on 2021/3/17 .
 */
interface WebViewClientInterface {
    fun onReceivedError(
        view: View,
        errorCode: Int,
        description: String?,
        failingUrl: String?
    )

    fun onReceivedError(
        view: View,
        request: WebResourceRequest?,
        error: WebResourceError?
    )

    fun onReceivedHttpError(
        view: View,
        request: WebResourceRequest?,
        errorResponse: WebResourceResponse?
    )

    fun onReceivedSslError(view: View, handler: SslErrorHandler?, error: SslError?)

    fun onPageFinished(view: View?, url: String?)

    fun shouldInterceptRequest(view: View?, url: String?): WebResourceResponse?

    fun shouldInterceptRequest(
        view: View?,
        request: WebResourceRequest?
    ): WebResourceResponse?

    fun shouldOverrideKeyEvent(view: View?, event: KeyEvent?): Boolean
    fun onSafeBrowsingHit(
        view: View?,
        request: WebResourceRequest?,
        threatType: Int,
        callback: SafeBrowsingResponse?
    )

    fun doUpdateVisitedHistory(view: View?, url: String?, isReload: Boolean)

    fun onRenderProcessGone(view: View?, detail: RenderProcessGoneDetail?): Boolean

    fun onReceivedLoginRequest(
        view: View?,
        realm: String?,
        account: String?,
        args: String?
    )

    fun onPageStarted(view: View?, url: String?, favicon: Bitmap?)

    fun onScaleChanged(view: View?, oldScale: Float, newScale: Float)

    fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean

    fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean

    fun onPageCommitVisible(view: View?, url: String?)

    fun onUnhandledKeyEvent(view: View?, event: KeyEvent?)

    fun onReceivedClientCertRequest(view: View?, request: ClientCertRequest?)

    fun onReceivedHttpAuthRequest(
        view: View?,
        handler: HttpAuthHandler?,
        host: String?,
        realm: String?
    )

    fun onTooManyRedirects(view: View?, cancelMsg: Message?, continueMsg: Message?)

    fun onFormResubmission(view: View?, dontResend: Message?, resend: Message?)

    fun onLoadResource(view: View?, url: String?)
}