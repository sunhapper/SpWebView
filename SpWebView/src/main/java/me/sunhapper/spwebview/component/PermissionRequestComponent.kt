package me.sunhapper.spwebview.component

import android.net.Uri

/**
 * Created by sunhapper on 2021/3/24 .
 */
interface PermissionRequestComponent {
    fun getOrigin(): Uri?
    fun getResources(): Array<String>?
    fun grant(resources: Array<String>?)
    fun deny()
}