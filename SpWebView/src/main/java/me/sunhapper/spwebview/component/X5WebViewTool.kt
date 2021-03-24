package me.sunhapper.spwebview.component

import android.content.Intent
import android.net.Uri
import android.net.http.SslCertificate
import android.os.Build
import androidx.annotation.RequiresApi
import com.tencent.smtt.export.external.interfaces.*
import com.tencent.smtt.sdk.ValueCallback
import com.tencent.smtt.sdk.WebChromeClient
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

fun WebResourceResponseComponent?.toX5(): WebResourceResponse? {
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
            override fun getCertificate(): SslCertificate? = it.certificate

            override fun getUrl(): String = ""

            override fun addError(error: Int): Boolean = it.addError(error)

            override fun hasError(error: Int): Boolean = it.hasError(error)

            override fun getPrimaryError(): Int = it.primaryError

            override fun toString(): String {
                return "primary error: " + getPrimaryError() +
                        " certificate: " + getCertificate() +
                        " on URL: " + getUrl()
            }

        }
    }
}

fun JsResult?.toComponent(): JsResultComponent? {
    return this?.let {
        object : JsResultComponent {
            override fun cancel() = it.cancel()
            override fun confirm() = it.confirm()
        }
    }
}

fun JsPromptResult?.toComponent(): JsPromptResultComponent? {
    return this?.let {
        object : JsPromptResultComponent {
            override fun confirm(result: String?) = it.confirm(result)
        }
    }
}

fun IX5WebChromeClient.CustomViewCallback?.toComponent(): CustomViewCallbackComponent? {
    return this?.let {
        object : CustomViewCallbackComponent {
            override fun onCustomViewHidden() = it.onCustomViewHidden()
        }
    }
}

fun GeolocationPermissionsCallback?.toComponent(): GeolocationPermissionsCallbackComponent? {
    return this?.let {
        object : GeolocationPermissionsCallbackComponent {
            override fun invoke(origin: String?, allow: Boolean, retain: Boolean) =
                it.invoke(origin, allow, retain)
        }
    }
}

fun ConsoleMessage?.toComponent(): ConsoleMessageComponent? {
    return this?.let {
        object : ConsoleMessageComponent {
            override fun messageLevel(): String? = it.messageLevel().name
            override fun message(): String? = it.message()
            override fun sourceId(): String? = it.sourceId()
            override fun lineNumber(): Int = it.lineNumber()
        }
    }
}

fun <T> ValueCallback<T>?.toComponent(): ValueCallbackComponent<T>? {
    return this?.let {
        object : ValueCallbackComponent<T> {
            override fun onReceiveValue(value: T) = it.onReceiveValue(value)
        }
    }
}

fun WebChromeClient.FileChooserParams?.toComponent(): FileChooserParamsComponent? {
    return this?.let {
        object : FileChooserParamsComponent {
            override fun getMode(): Int = it.mode
            override fun getAcceptTypes(): Array<String>? = it.acceptTypes
            override fun isCaptureEnabled(): Boolean = it.isCaptureEnabled
            override fun getTitle(): CharSequence? = it.title
            override fun getFilenameHint(): String? = it.filenameHint
            override fun createIntent(): Intent? = it.createIntent()
        }
    }
}