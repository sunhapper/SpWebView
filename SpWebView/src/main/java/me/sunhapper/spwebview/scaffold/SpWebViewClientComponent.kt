package me.sunhapper.spwebview.scaffold

import android.graphics.Bitmap
import android.view.View
import me.sunhapper.spwebview.component.*
import me.sunhapper.spwebview.config.SpWebViewConfig
import me.sunhapper.spwebview.scaffold.intercepter.SpRequestInterceptor

/**
 * Created by sunhapper on 2021/3/25 .
 */
class SpWebViewClientComponent<WebView : View>(val spWebViewConfig: SpWebViewConfig)
    : WebViewClientComponent<WebView> {
    override fun onReceivedError(
        view: WebView,
        errorCode: Int,
        description: String?,
        failingUrl: String?) {
        TODO("Not yet implemented")
    }

    override fun onReceivedError(
        view: WebView,
        request: WebResourceRequestComponent?,
        error: WebResourceErrorComponent?) {
        TODO("Not yet implemented")
    }

    override fun onReceivedHttpError(
        view: WebView,
        request: WebResourceRequestComponent?,
        errorResponse: WebResourceResponseComponent?) {
        TODO("Not yet implemented")
    }

    override fun onReceivedSslError(
        view: WebView,
        handler: SslErrorHandlerComponent?,
        error: SslErrorComponent?) {
        TODO("Not yet implemented")
    }

    override fun onPageStarted(view: WebView, url: String?, favicon: Bitmap?) {
        TODO("Not yet implemented")
    }

    override fun onPageFinished(webView: WebView, url: String?) {
        TODO("Not yet implemented")
    }

    override fun shouldInterceptRequest(
        webView: WebView,
        url: String?): WebResourceResponseComponent? {
        return SpRequestInterceptor(spWebViewConfig).interceptRequest(url)
    }

    override fun shouldInterceptRequest(
        webView: WebView,
        request: WebResourceRequestComponent?): WebResourceResponseComponent? {
        return SpRequestInterceptor(spWebViewConfig).interceptRequest(request)
    }

    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun shouldOverrideUrlLoading(
        view: WebView,
        request: WebResourceRequestComponent?): Boolean {
        TODO("Not yet implemented")
    }

}