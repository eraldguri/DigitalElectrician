package com.erald.digitalelectrician.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.widget.TextView

class DEClipBoardManager(private val context: Context) {

    fun copyTextFromClipBoard(textView: TextView) {
        val manager: ClipboardManager = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textView.text)
        manager.setPrimaryClip(clipData)
    }

}