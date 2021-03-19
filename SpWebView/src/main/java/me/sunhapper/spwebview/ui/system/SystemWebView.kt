package me.sunhapper.spwebview.ui.system

import android.content.Context
import android.util.AttributeSet
import android.webkit.*
import me.sunhapper.spwebview.log.Logger

/**
 * Created by sunhapper on 2021/3/11 .
 */
class SystemWebView : WebView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        defStyleRes: Int
    ) : super(context, attrs, defStyleAttr, defStyleRes)

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyleAttr: Int,
        privateBrowsing: Boolean
    ) : super(context, attrs, defStyleAttr, privateBrowsing)

    override fun loadUrl(url: String, additionalHttpHeaders: MutableMap<String, String>) {
        super.loadUrl(url, additionalHttpHeaders)
        val params = additionalHttpHeaders.toList().joinToString(prefix = "[", postfix = "]") {
            "${it.first}:${it.second}"
        }
        Logger.i(msg = "url:$url \n  additionalHttpHeaders:$params")
        getUrl()
    }

    override fun loadUrl(url: String) {
        super.loadUrl(url)
        Logger.i(msg = "url:$url")
    }

    override fun evaluateJavascript(script: String, resultCallback: ValueCallback<String>?) {

        val delegateCallBack = ValueCallback<String> {
            Logger.i(msg = "evaluateJavascript onReceiveValue:$it")
            resultCallback?.onReceiveValue(it)
        }
        super.evaluateJavascript(script, delegateCallBack)
        Logger.i(msg = "script:$script")
    }

    override fun onResume() {
        super.onResume()
        Logger.i(msg = "onResume originalUrl:$originalUrl url:$url")
    }

    override fun destroy() {
        Logger.i(msg = "destroy originalUrl:$originalUrl url:$url")
        super.destroy()
    }

    override fun onPause() {
        Logger.i(msg = "onPause originalUrl:$originalUrl url:$url")
        super.onPause()
    }
}