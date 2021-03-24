package me.sunhapper.spwebview.component

import android.content.Intent
import android.net.Uri

/**
 * Created by sunhapper on 2021/3/24 .
 */
interface FileChooserParamsComponent {
    fun getMode(): Int
    fun getAcceptTypes(): Array<String>?
    fun isCaptureEnabled(): Boolean
    fun getTitle(): CharSequence?
    fun getFilenameHint(): String?
    fun createIntent(): Intent?
}