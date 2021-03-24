package me.sunhapper.spwebview.component

/**
 * Created by sunhapper on 2021/3/24 .
 */
interface ValueCallbackComponent<T> {
    fun onReceiveValue(value: T)
}