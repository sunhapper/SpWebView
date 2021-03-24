package me.sunhapper.spwebview.component

/**
 * Created by sunhapper on 2021/3/22 .
 */
interface GeolocationPermissionsCallbackComponent {
    fun invoke(
        origin: String?,
        allow: Boolean,
        retain: Boolean
    )
}