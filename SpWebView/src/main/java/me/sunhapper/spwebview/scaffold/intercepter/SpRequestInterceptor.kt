package me.sunhapper.spwebview.scaffold.intercepter

import android.webkit.MimeTypeMap
import me.sunhapper.spwebview.component.WebResourceRequestComponent
import me.sunhapper.spwebview.component.WebResourceResponseComponent
import me.sunhapper.spwebview.component.WebResourceResponseComponentImpl
import me.sunhapper.spwebview.config.SpWebViewConfig
import me.sunhapper.spwebview.tool.Logger

/**
 * Created by sunhapper on 2021/3/25 .
 */
class SpRequestInterceptor(val spWebViewConfig: SpWebViewConfig) {
    fun interceptRequest(url: String?): WebResourceResponseComponent? {
        if (url == null) {
            return null
        }
        val inputStream = spWebViewConfig.requestInterceptor(url) ?: return null
        val mimeType = getMimeTypeFromUrl(url) ?: return null
        val responseHeader: MutableMap<String, String> = HashMap()
        responseHeader["Access-Control-Allow-Origin"] = "*"
        responseHeader["Access-Control-Allow-Headers"] = "X-Requested-With"
        responseHeader["Access-Control-Allow-Methods"] = "POST, GET, OPTIONS, DELETE"
        responseHeader["Access-Control-Allow-Credentials"] = "true"
        val webResourceResponseComponent = WebResourceResponseComponentImpl()
        webResourceResponseComponent.encoding = "UTF-8"
        webResourceResponseComponent.inputStream = inputStream
        webResourceResponseComponent.mimeType = mimeType
        webResourceResponseComponent.responseHeaders = responseHeader
        webResourceResponseComponent.reasonPhrase = "OK"
        webResourceResponseComponent.statusCode = 200
        return webResourceResponseComponent

    }

    fun interceptRequest(request: WebResourceRequestComponent?): WebResourceResponseComponent? {
        if (request == null) {
            return null
        }
        request.getRequestHeaders()?.forEach {
            Logger.i("WebResourceRequest", "Header:${it.key} - ${it.value}")
        }
        return interceptRequest(request.getUrl()?.toString())
    }

    private fun getMimeTypeFromUrl(url: String): String? {
        return MimeTypeMap.getSingleton()
            .getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(url))
    }

}