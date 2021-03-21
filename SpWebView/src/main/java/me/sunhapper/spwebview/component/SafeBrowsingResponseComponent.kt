package me.sunhapper.spwebview.component

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface SafeBrowsingResponseComponent {
    fun showInterstitial(allowReporting: Boolean)
    fun proceed(report: Boolean)
    fun backToSafety(report: Boolean)
}