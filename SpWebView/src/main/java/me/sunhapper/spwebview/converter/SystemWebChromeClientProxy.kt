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
        return if (spWebViewConfig.needSpPrompt) {
            webChromeClientComponent.onJsPrompt(
                view,
                url,
                message,
                defaultValue,
                result.toComponent()
            )
        } else {
            webChromeClient?.onJsPrompt(view, url, message, defaultValue, result)
                ?: super.onJsPrompt(view, url, message, defaultValue, result)
        }
    }

    override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
        if (spWebViewConfig.needSpShowCustomView) {
            webChromeClientComponent.onShowCustomView(view, callback.toComponent())
        }
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, callback)
        } else {
            super.onShowCustomView(
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
                callback.toComponent())
        }
        if (webChromeClient != null) {
            webChromeClient.onShowCustomView(view, requestedOrientation, callback)
        } else {
            super.onShowCustomView(view, requestedOrientation, callback)
        }
    }

    override fun onHideCustomView() {
        if (spWebViewConfig.needSpShowCustomView) {
            webChromeClientComponent.onHideCustomView()
        }
        if (webChromeClient != null) {
            webChromeClient.onHideCustomView()
        } else {
            super.onHideCustomView()
        }
    }

    override fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        callback: GeolocationPermissions.Callback?
    ) {
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsShowPrompt(origin, callback)
        } else {
            super.onGeolocationPermissionsShowPrompt(origin, callback)
        }
    }

    override fun onPermissionRequest(request: PermissionRequest?) {
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequest(request)
        } else {
            super.onPermissionRequest(request)
        }
    }

    override fun onPermissionRequestCanceled(request: PermissionRequest?) {
        if (webChromeClient != null) {
            webChromeClient.onPermissionRequestCanceled(request)
        } else {
            super.onPermissionRequestCanceled(request)
        }
    }

    override fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?) {
        webChromeClientComponent.onConsoleMessage(message, lineNumber, sourceID)
        if (webChromeClient != null) {
            webChromeClient.onConsoleMessage(message, lineNumber, sourceID)
        } else {
            super.onConsoleMessage(message, lineNumber, sourceID)
        }
    }

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        webChromeClientComponent.onConsoleMessage(consoleMessage.toComponent())
        return webChromeClient?.onConsoleMessage(consoleMessage)
            ?: super.onConsoleMessage(consoleMessage)
    }

    fun openFileChooser(uploadMsg: ValueCallback<Uri>, acceptType: String?, capture: String?) {
        if (spWebViewConfig.needSpFileChoose) {
            webChromeClientComponent.openFileChooser(uploadMsg.toComponent(), acceptType,capture)
        }
    }


    override fun onShowFileChooser(
        webView: WebView,
        filePathCallback: ValueCallback<Array<Uri>>?,
        fileChooserParams: FileChooserParams?
    ): Boolean {
        val upLevelResult =
            webChromeClient?.onShowFileChooser(webView, filePathCallback, fileChooserParams)
                ?: false
        if (upLevelResult) {
            return true
        }
        return if (spWebViewConfig.needSpFileChoose &&
            webChromeClientComponent.onShowFileChooser(
                webView,
                filePathCallback.toComponent(),
                fileChooserParams.toComponent())) {
            true
        } else {
            super.onShowFileChooser(webView, filePathCallback, fileChooserParams)
        }
    }

    override fun onReceivedTouchIconUrl(view: WebView?, url: String?, precomposed: Boolean) {
        if (webChromeClient != null) {
            webChromeClient.onReceivedTouchIconUrl(view, url, precomposed)
        } else {
            super.onReceivedTouchIconUrl(view, url, precomposed)
        }
    }

    override fun onReceivedIcon(view: WebView, icon: Bitmap?) {
        webChromeClientComponent.onReceivedIcon(view, icon)
        if (webChromeClient != null) {
            webChromeClient.onReceivedIcon(view, icon)
        } else {
            super.onReceivedIcon(view, icon)
        }
    }

    override fun onExceededDatabaseQuota(
        url: String?,
        databaseIdentifier: String?,
        quota: Long,
        estimatedDatabaseSize: Long,
        totalQuota: Long,
        quotaUpdater: WebStorage.QuotaUpdater?
    ) {
        if (webChromeClient != null) {
            webChromeClient.onExceededDatabaseQuota(
                url,
                databaseIdentifier,
                quota,
                estimatedDatabaseSize,
                totalQuota,
                quotaUpdater
            )
        } else {
            super.onExceededDatabaseQuota(
                url,
                databaseIdentifier,
                quota,
                estimatedDatabaseSize,
                totalQuota,
                quotaUpdater
            )
        }
    }

    override fun onReceivedTitle(view: WebView, title: String?) {
        webChromeClientComponent.onReceivedTitle(view, title)
        if (webChromeClient != null) {
            webChromeClient.onReceivedTitle(view, title)
        } else {
            super.onReceivedTitle(view, title)
        }
    }

    override fun onReachedMaxAppCacheSize(
        requiredStorage: Long,
        quota: Long,
        quotaUpdater: WebStorage.QuotaUpdater?
    ) {
        if (webChromeClient != null) {
            webChromeClient.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater)
        } else {
            super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater)
        }
    }

    override fun onProgressChanged(view: WebView, newProgress: Int) {
        webChromeClientComponent.onProgressChanged(view, newProgress)
        if (webChromeClient != null) {
            webChromeClient.onProgressChanged(view, newProgress)
        } else {
            super.onProgressChanged(view, newProgress)
        }
    }

    override fun onJsConfirm(
        view: WebView,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return if (spWebViewConfig.needSpDialog) {
            webChromeClientComponent.onJsConfirm(view, url, message, result.toComponent())
        } else {
            webChromeClient?.onJsConfirm(view, url, message, result)
                ?: super.onJsConfirm(view, url, message, result)
        }
    }

    override fun getVisitedHistory(callback: ValueCallback<Array<String>>?) {
        if (webChromeClient != null) {
            webChromeClient.getVisitedHistory(callback)
        } else {
            super.getVisitedHistory(callback)
        }
    }

    override fun getVideoLoadingProgressView(): View? {
        return if (webChromeClient != null) {
            webChromeClient.videoLoadingProgressView
        } else {
            super.getVideoLoadingProgressView()
        }
    }

    override fun onGeolocationPermissionsHidePrompt() {
        if (webChromeClient != null) {
            webChromeClient.onGeolocationPermissionsHidePrompt()
        } else {
            super.onGeolocationPermissionsHidePrompt()
        }
    }

    override fun getDefaultVideoPoster(): Bitmap? {
        return if (webChromeClient != null) {
            webChromeClient.defaultVideoPoster
        } else {
            super.getDefaultVideoPoster()
        }
    }

    override fun onJsBeforeUnload(
        view: WebView?,
        url: String?,
        message: String?,
        result: JsResult?
    ): Boolean {
        return webChromeClient?.onJsBeforeUnload(view, url, message, result)
            ?: super.onJsBeforeUnload(view, url, message, result)
    }


    override fun onCreateWindow(
        view: WebView,
        isDialog: Boolean,
        isUserGesture: Boolean,
        resultMsg: Message?
    ): Boolean {
        return webChromeClient?.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
            ?: super.onCreateWindow(view, isDialog, isUserGesture, resultMsg)
    }

    override fun onCloseWindow(window: WebView?) {
        if (webChromeClient != null) {
            webChromeClient.onCloseWindow(window)
        } else {
            super.onCloseWindow(window)
        }
    }

    override fun onJsTimeout(): Boolean {
        return webChromeClient?.onJsTimeout() ?: super.onJsTimeout()
    }


}