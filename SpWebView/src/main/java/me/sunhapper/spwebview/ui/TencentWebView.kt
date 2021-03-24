package me.sunhapper.spwebview.ui

import android.content.Context
import android.util.AttributeSet
import com.tencent.smtt.sdk.*

/**
 * Created by sunhapper on 2021/3/11 .
 */
class TencentWebView : WebView {
    constructor(p0: Context?) : super(p0)
    constructor(p0: Context?, p1: AttributeSet?) : super(p0, p1)
    constructor(p0: Context?, p1: AttributeSet?, p2: Int) : super(p0, p1, p2)
    constructor(p0: Context?, p1: AttributeSet?, p2: Int, p3: Boolean) : super(p0, p1, p2, p3)
    constructor(
        p0: Context?,
        p1: AttributeSet?,
        p2: Int,
        p3: MutableMap<String, Any>?,
        p4: Boolean
    ) : super(p0, p1, p2, p3, p4)
}