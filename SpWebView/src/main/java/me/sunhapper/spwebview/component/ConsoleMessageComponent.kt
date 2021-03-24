package me.sunhapper.spwebview.component
/**
 * Created by sunhapper on 2021/3/24 .
 */
interface ConsoleMessageComponent {

    fun messageLevel(): String?

    fun message(): String?

    fun sourceId(): String?

    fun lineNumber(): Int
}