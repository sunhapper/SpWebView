package me.sunhapper.spwebview.converter

import android.webkit.WebResourceRequest
import android.webkit.WebResourceResponse

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

fun com.tencent.smtt.export.external.interfaces.WebResourceRequest?.toX5(): WebResourceRequest? {
    return this?.let {
        SystemResourceRequest(it)
    }
}