package me.sunhapper.spwebview.component

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
        toComponent: JsPromptResultComponent?
    ): Boolean

    fun onShowCustomView(view: View?, toComponent: CustomViewCallbackComponent?)
    fun onShowCustomView(
        view: View?,
        requestedOrientation: Int,
        toComponent: CustomViewCallbackComponent?
    )

    fun onGeolocationPermissionsShowPrompt(
        origin: String?,
        toComponent: GeolocationPermissionsCallbackComponent?
    )
}