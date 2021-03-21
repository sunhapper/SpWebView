package me.sunhapper.spwebview.component

import android.net.http.SslCertificate

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface SslErrorComponent {

    fun getCertificate(): SslCertificate?

    fun getUrl(): String?

    fun addError(error: Int): Boolean

    fun hasError(error: Int): Boolean

    fun getPrimaryError(): Int

    override fun toString(): String

}