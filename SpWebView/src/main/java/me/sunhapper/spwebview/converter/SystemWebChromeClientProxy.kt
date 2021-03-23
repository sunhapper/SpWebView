package me.sunhapper.spwebview.converter

import android.graphics.Bitmap
import android.net.Uri
import android.os.Message
import android.view.View
import android.webkit.*
import me.sunhapper.spwebview.component.WebChromeClientComponent
import me.sunhapper.spwebview.component.toComponent
import me.sunhapper.spwebview.config.SpWebViewConfig

/**
 * Created by sunhapper on 2021/3/22 .
 */
class SystemWebChromeClientProxy(
    private val webChromeClientComponent: WebChromeClientComponent<WebView>,
    private val webChromeClient: WebChromeClient?,
    private val spWebViewConfig: SpWebViewConfig
) : WebChromeClient() {
    override fun onRequestFocus(view: WebView) {
        webChromeClient?.onRequestFocus(view)
    }

    override fun onJsAlert(
        view: WebView,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return if (spWebViewConfig.needSpToast) {
            webChromeClientComponent.onJsAlert(view, url, message, result.toComponent())
        } else {
            webChromeClient?.onJsAlert(view, url, message, result) ?: super.onJsAlert(
                view,
                url,
                message,
                result
            )
        }
    }

    override fun onJsPrompt(
        view: WebView,
        url: String?,
        message: String?,
        defaultValue: String?,
        result: JsPromptResult?
    ): Boolean {
        return if (spWebViewConfig.needSpDialog) {
            webChromeClient?.onJsPrompt(view, url, message, defaultValue, result)
                ?: super.onJsPrompt(view, url, message, defaultValue, result)
        } else {
            webChromeClientComponent.onJsPrompt(
                view,
                url,
                message,
                defaultValue,
                result.toComponent()
            )
        }
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        if (spWebViewConfig.needSpShowCustomView) {
            webChromeClientComponent.onShowCustomView(view, callback.toComponent())
        } else {
            webChromeClient?.onShowCustomView(view, callback) ?: super.onShowCustomView(
                view,
                callback
            )
        }
    }

    override fun onShowCustomView(
        view: View?,
        requestedOrientation: Int,
        callback: CustomViewCallback?
    ) {
        if (spWebViewConfig.needSpShowCustomView) {
            webChromeClientComponent.onShowCustomView(
                view,
                requestedOrientation,
                callback.toComponent()
            )
        } else {
            webChromeClient?.onShowCustomView(view, requestedOrientation, callback)
                ?: super.onShowCustomView(view, requestedOrientation, callback)
        }
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        callback: GeolocationPermissions.Callback?
    ) {
        webChromeClientComponent.onGeolocationPermissionsShowPrompt(origin, callback.toComponent())
    }

    override fun onPermissionRequest(request: PermissionRequest?) {
        super.onPermissionRequest(request)
    }

    override fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?) {
        super.onConsoleMessage(message, lineNumber, sourceID)
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        return super.onConsoleMessage(consoleMessage)
    }

    override fun onPermissionRequestCanceled(request: PermissionRequest?) {
        super.onPermissionRequestCanceled(request)
    }

    override fun onShowFileChooser(
        webView: WebView?,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        return super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
    }

    override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
        super.onReceivedTouchIconUrl(view, url, precomposed)
    }

    override fun onReceivedIcon(view: WebView?, icon: Bitmap?) {
        super.onReceivedIcon(view, icon)
    }

    override fun onExceededDatabaseQuota(
        url: String?,
        databaseIdentifier: String?,
        quota: Long,
        estimatedDatabaseSize: Long,
        totalQuota: Long,
        quotaUpdater: WebStorage.QuotaUpdater?
    ) {
        super.onExceededDatabaseQuota(
            url,
            databaseIdentifier,
            quota,
            estimatedDatabaseSize,
            totalQuota,
            quotaUpdater
        )
    }

    override fun onReceivedTitle(view: WebView?, title: String?) {
        super.onReceivedTitle(view, title)
    }

    override fun onReachedMaxAppCacheSize(
        requiredStorage: Long,
        quota: Long,
        quotaUpdater: WebStorage.QuotaUpdater?
    ) {
        super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater)
    }

    override fun onProgressChanged(view: WebView?, newProgress: Int) {
        super.onProgressChanged(view, newProgress)
    }

    override fun onJsConfirm(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsConfirm(view, url, message, result)
    }

    override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
        super.getVisitedHistory(callback)
    }

    override fun getVideoLoadingProgressView(): View? {
        return super.getVideoLoadingProgressView()
    }

    override fun onGeolocationPermissionsHidePrompt() {
        super.onGeolocationPermissionsHidePrompt()
    }

    override fun getDefaultVideoPoster(): Bitmap? {
        return super.getDefaultVideoPoster()
    }

    override fun onJsBeforeUnload(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return super.onJsBeforeUnload(view, url, message, result)
    }

    override fun onHideCustomView() {
        super.onHideCustomView()
    }

    override fun onCreateWindow(
        view: WebView?,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?
    ): Boolean {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    override fun onCloseWindow(window: WebView?) {
        super.onCloseWindow(window)
    }

    override fun onJsTimeout(): Boolean {
        return super.onJsTimeout()
    }
}