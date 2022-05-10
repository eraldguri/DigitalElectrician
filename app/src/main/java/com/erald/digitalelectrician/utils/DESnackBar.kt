package com.erald.digitalelectrician.utils

import android.graphics.Color
import android.view.View
import android.widget.TextView
import com.erald.digitalelectrician.R
import com.google.android.material.snackbar.Snackbar

class DESnackBar {

    companion object {

        fun show(view: View, text: String, duration: Int) {
            val snackBar = Snackbar.make(view, text, duration)
            val snackBarView = snackBar.view
            val textView = snackBarView.rootView.findViewById<TextView>(R.id.textViewSnack)
            textView.setTextColor(Color.WHITE)
            textView.textSize = 12F

            snackBar.setAction("OK", View.OnClickListener {
                snackBar.dismiss()
            })

            snackBar.show()
        }

    }

}