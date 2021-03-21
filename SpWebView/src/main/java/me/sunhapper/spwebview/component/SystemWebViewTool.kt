package me.sunhapper.spwebview.component

import android.net.Uri
import android.net.http.SslCertificate
import android.net.http.SslError
import android.os.Build
import android.webkit.*
import androidx.annotation.RequiresApi
import java.io.InputStream
import java.security.Principal
import java.security.PrivateKey
import java.security.cert.X509Certificate

/**
 * Created by sunhapper on 2021/3/21 .
 */
fun WebResourceResponse?.toComponent(): WebResourceResponseComponent? {
    return this?.let {
        object : WebResourceResponseComponent {
            override var mimeType: String?
                get() = it.mimeType
                set(value) {
                    it.mimeType = value
                }
            override var encoding: String?
                get() = it.encoding
                set(value) {
                    it.encoding = value
                }
            override val statusCode: Int
                get() = it.statusCode

            override val reasonPhrase: String
                get() = it.reasonPhrase
            override var responseHeaders: Map<String, String>?
                get() = it.responseHeaders
                set(value) {
                    it.responseHeaders = value
                }
            override var data: InputStream?
                get() = it.data
                set(value) {
                    it.data = value
                }
        }
    }
}

fun WebResourceResponseComponent?.toSystem(): WebResourceResponse? {
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


fun WebResourceRequest?.toComponent(): WebResourceRequestComponent? {
    return this?.let {
        object : WebResourceRequestComponent {
            override fun getUrl(): Uri? = it.url
            override fun isForMainFrame(): Boolean = it.isForMainFrame

            @RequiresApi(Build.VERSION_CODES.N)
            override fun isRedirect(): Boolean = it.isRedirect
            override fun hasGesture(): Boolean = it.hasGesture()
            override fun getMethod(): String? = it.method
            override fun getRequestHeaders(): Map<String, String>? = it.requestHeaders

        }
    }
}

fun WebResourceError?.toComponent(): WebResourceErrorComponent? {
    return this?.let {
        object : WebResourceErrorComponent {
            @RequiresApi(Build.VERSION_CODES.M)
            override fun getErrorCode(): Int = it.errorCode

            @RequiresApi(Build.VERSION_CODES.M)
            override fun getDescription(): CharSequence? = it.description

        }
    }
}

fun SslErrorHandler?.toComponent(): SslErrorHandlerComponent? {
    return this?.let {
        object : SslErrorHandlerComponent {
            override fun proceed() = it.proceed()
            override fun cancel() = it.cancel()
        }
    }
}

fun SafeBrowsingResponse?.toComponent(): SafeBrowsingResponseComponent? {
    return this?.let {
        object : SafeBrowsingResponseComponent {
            @RequiresApi(Build.VERSION_CODES.O_MR1)
            override fun showInterstitial(allowReporting: Boolean) =
                it.showInterstitial(allowReporting)

            @RequiresApi(Build.VERSION_CODES.O_MR1)
            override fun proceed(report: Boolean) = it.proceed(report)

            @RequiresApi(Build.VERSION_CODES.O_MR1)
            override fun backToSafety(report: Boolean) = it.backToSafety(report)

        }
    }
}

fun RenderProcessGoneDetail?.toComponent(): RenderProcessGoneDetailComponent? {
    return this?.let {
        object : RenderProcessGoneDetailComponent {
            @RequiresApi(Build.VERSION_CODES.O)
            override fun didCrash(): Boolean = it.didCrash()

            @RequiresApi(Build.VERSION_CODES.O)
            override fun rendererPriorityAtExit(): Int = it.rendererPriorityAtExit()
        }
    }
}

fun ClientCertRequest?.toComponent(): ClientCertRequestComponent? {
    return this?.let {
        object : ClientCertRequestComponent {
            override fun getKeyTypes(): Array<String>? = it.keyTypes

            override fun getPrincipals(): Array<Principal>? = it.principals

            override fun getHost(): String? = it.host

            override fun getPort(): Int = it.port

            override fun proceed(privateKey: PrivateKey?, chain: Array<X509Certificate>?) =
                it.proceed(privateKey, chain)

            override fun ignore() = it.ignore()

            override fun cancel() = it.cancel()

        }
    }
}

fun HttpAuthHandler?.toComponent(): HttpAuthHandlerComponent? {
    return this?.let {
        object : HttpAuthHandlerComponent {
            override fun useHttpAuthUsernamePassword(): Boolean = it.useHttpAuthUsernamePassword()
            override fun cancel() = it.cancel()
            override fun proceed(username: String?, password: String?) =
                it.proceed(username, password)

        }
    }
}

fun SslError?.toComponent(): SslErrorComponent? {
    return this?.let {
        object : SslErrorComponent {
            override fun getCertificate(): SslCertificate? =it.certificate

            override fun getUrl(): String? =it.url

            override fun addError(error: Int): Boolean=it.addError(error)

            override fun hasError(error: Int): Boolean =it.hasError(error)

            override fun getPrimaryError(): Int =it.primaryError

            override fun toString(): String {
                return "primary error: " + getPrimaryError() +
                        " certificate: " + getCertificate() +
                        " on URL: " + getUrl()
            }

        }
    }
}