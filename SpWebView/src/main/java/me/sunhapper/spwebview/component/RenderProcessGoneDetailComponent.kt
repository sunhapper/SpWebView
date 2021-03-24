package me.sunhapper.spwebview.component

import android.webkit.WebView

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface RenderProcessGoneDetailComponent {
    fun didCrash(): Boolean
    fun rendererPriorityAtExit(): Int
}