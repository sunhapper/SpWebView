package me.sunhapper.spwebview.component

import android.graphics.Bitmap
import android.net.Uri
import android.view.View

/**
 * Created by sunhapper on 2021/3/22 .
 */
interface WebChromeClientComponent<WebView : View> {
    //    fun onRequestFocus(view: WebView)
    fun onJsAlert(
        view: WebView,
        url: String?,
        message: String?,
        result: JsResultComponent?
    ): Boolean

    fun onJsPrompt(
        view: WebView,
        url: String?,
        message: String?,
        defaultValue: String?,
        jsPromptResultComponent: JsPromptResultComponent?
    ): Boolean

    fun onShowCustomView(view: View?, customViewCallbackComponent: CustomViewCallbackComponent?)
    fun onShowCustomView(
        view: View?,
        requestedOrientation: Int,
        customViewCallbackComponent: CustomViewCallbackComponent?
    )

    fun onHideCustomView()

    fun onConsoleMessage(message: String?, lineNumber: Int, sourceID: String?)
    fun onConsoleMessage(message: ConsoleMessageComponent?)
    fun onShowFileChooser(
        webView: WebView,
        valueCallbackComponent: ValueCallbackComponent<Array<Uri>>?,
        fileChooserParamsComponent: FileChooserParamsComponent?
    ): Boolean

    fun openFileChooser(
        valueCallbackComponent: ValueCallbackComponent<Uri>?,
        acceptType: String?,
        capture: String?)

    fun onReceivedIcon(view: WebView, icon: Bitmap?)
    fun onReceivedTitle(view: WebView, title: String?)
    fun onProgressChanged(view: WebView, newProgress: Int)
    fun onJsConfirm(
        view: WebView,
        url: String?,
        message: String?,
        result: JsResultComponent?): Boolean


    // TODO: 2021/3/24 onCreateWindow
//    fun onCreateWindow(
//        view: WebView,
//        isDialog: Boolean,
//        isUserGesture: Boolean,
//        resultMsg: Message?
//    ): Boolean

    //only sys
//    fun onPermissionRequest(request: PermissionRequestComponent?)
//    fun onPermissionRequestCanceled(request: PermissionRequestComponent?)


}