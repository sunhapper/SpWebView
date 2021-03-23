package me.sunhapper.spwebview.component

import android.graphics.Bitmap
import android.os.Message
import android.view.KeyEvent
import android.view.View

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

    fun onReceivedSslError(
        view: WebView,
        handler: SslErrorHandlerComponent?,
        error: SslErrorComponent?
    )

    fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?)
    fun onPageFinished(webView: WebView, url: String?)

    fun shouldInterceptRequest(webView: WebView, url: String?): WebResourceResponseComponent?
    fun shouldInterceptRequest(
        webView: WebView,
        request: WebResourceRequestComponent?
    ): WebResourceResponseComponent?

    fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean
    fun shouldOverrideUrlLoading(view: WebView, request: WebResourceRequestComponent?): Boolean




    //todo ScaleChanged
//    fun onScaleChanged(view: WebView, oldScale: Float, newScale: Float)

    //todo 理解onPageCommitVisible能干什么
//    fun onPageCommitVisible(view: WebView, url: String?)

    //todo 历史记录
//    fun doUpdateVisitedHistory(view: WebView, url: String?, reload: Boolean)
    //todo 过多重定向
//    fun onTooManyRedirects(view: WebView, cancelMsg: Message?, continueMsg: Message?)


//    fun onRenderProcessGone(view: WebView, detail: RenderProcessGoneDetailComponent?): Boolean
//    fun onReceivedLoginRequest(
//        view: WebView,
//        realm: String?,
//        account: String?,
//        args: String?
//    )
//    fun onLoadResource(view: WebView, url: String?)
//    fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent?): Boolean
//    fun onUnhandledKeyEvent(view: WebView, event: KeyEvent?)
//    fun onReceivedClientCertRequest(view: WebView, request: ClientCertRequestComponent?)
//    fun onFormResubmission(view: WebView, dontResend: Message?, resend: Message?)
//    fun onReceivedHttpAuthRequest(
//        view: WebView,
//        handler: HttpAuthHandlerComponent?,
//        host: String?,
//        realm: String?
//    )
}