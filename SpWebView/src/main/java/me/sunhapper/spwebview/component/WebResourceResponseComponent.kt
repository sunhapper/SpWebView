package me.sunhapper.spwebview.component

import java.io.InputStream

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface WebResourceResponseComponent {
    var mimeType: String?
    var encoding: String?
    val statusCode: Int
    val reasonPhrase: String
    var responseHeaders: Map<String, String>?
    var inputStream: InputStream?
    fun setStatusCodeAndReasonPhrase(statusCode: Int, reasonPhrase: String)
}