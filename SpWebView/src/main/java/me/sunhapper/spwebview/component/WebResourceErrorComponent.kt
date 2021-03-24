package me.sunhapper.spwebview.component

/**
 * Created by sunhapper on 2021/3/21 .
 */
interface WebResourceErrorComponent {
    fun getErrorCode(): Int
    fun getDescription(): CharSequence?
}