package me.sunhapper.spwebview.component

import java.io.InputStream

/**
 * Created by sunhapper on 2021/3/25 .
 */
class WebResourceResponseComponentImpl : WebResourceResponseComponent {
    override var mimeType: String? = null
    override var encoding: String? = null
    override var statusCode = 0
    override var reasonPhrase: String = ""
    override var responseHeaders: Map<String, String>? = null
    override var inputStream: InputStream? = null
    override fun setStatusCodeAndReasonPhrase(statusCode: Int, reasonPhrase: String) {
        this.statusCode = statusCode
        this.reasonPhrase = reasonPhrase
    }
}