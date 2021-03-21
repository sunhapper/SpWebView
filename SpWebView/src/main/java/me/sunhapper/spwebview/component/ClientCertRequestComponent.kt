package me.sunhapper.spwebview.component

import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface ClientCertRequestComponent {
    fun getKeyTypes(): Array<String>?
    fun getPrincipals(): Array<Principal>?
    fun getHost(): String?
    fun getPort(): Int
    fun proceed(privateKey: PrivateKey?, chain: Array<X509Certificate>?)
    fun ignore()
    fun cancel()
}