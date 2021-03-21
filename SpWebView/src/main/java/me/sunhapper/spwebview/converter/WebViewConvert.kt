package me.sunhapper.spwebview.converter

import android.net.Uri
import android.os.Build
import android.webkit.SslErrorHandler
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse
import androidx.annotation.RequiresApi

/**
 * Created by sunhapper on 2021/3/19 .
 */
fun WebResourceResponse?.toX5(): com.tencent.smtt.export.external.interfaces.WebResourceResponse? {
    return this?.let {
        com.tencent.smtt.export.external.interfaces.WebResourceResponse(
            it.mimeType,
            it.encoding,
            it.statusCode,
            it.reasonPhrase,
            it.responseHeaders,
            it.data
        )
    }
}

fun com.tencent.smtt.export.external.interfaces.WebResourceResponse?.toSystem(): WebResourceResponse? {
    return this?.let {
        WebResourceResponse(
            it.mimeType,
            it.encoding,
            it.statusCode,
            it.reasonPhrase,
            it.responseHeaders,
            it.data
        )
    }
}

fun WebResourceRequest?.toX5(): com.tencent.smtt.export.external.interfaces.WebResourceRequest? {
    return this?.let {
        X5ResourceRequest(it)
    }
}

fun com.tencent.smtt.export.external.interfaces.WebResourceRequest?.toSystem(): WebResourceRequest? {
    return this?.let {
        object :WebResourceRequest{
            override fun getUrl(): Uri = it.url
            override fun isForMainFrame(): Boolean = it.isForMainFrame
            override fun isRedirect(): Boolean = it.isRedirect
            override fun hasGesture(): Boolean = it.hasGesture()
            override fun getMethod(): String = it.method
            override fun getRequestHeaders(): Map<String, String> = it.requestHeaders

        }
    }
}
@RequiresApi(Build.VERSION_CODES.M)
fun WebResourceError?.toX5():com.tencent.smtt.export.external.interfaces.WebResourceError?{
    return this?.let {
        object : com.tencent.smtt.export.external.interfaces.WebResourceError() {
            override fun getDescription(): CharSequence = it.description
            override fun getErrorCode(): Int = it.errorCode
        }
    }
}
