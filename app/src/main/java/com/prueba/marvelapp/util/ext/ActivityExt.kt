package com.prueba.marvelapp.util.ext

import android.app.Activity
import android.app.Dialog
import android.content.ClipData
import android.content.ClipDescription
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import com.prueba.marvelapp.R
import com.prueba.marvelapp.util.MyDragShadowBuilder



fun Activity.createProgressDialog(): Dialog {
    val progressDialog = Dialog(this)
    progressDialog.show()
    if (progressDialog.window != null) {
        progressDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    }
    progressDialog.setContentView(R.layout.progress_dialog)
    progressDialog.setCancelable(false)
    progressDialog.setCanceledOnTouchOutside(false)
    return progressDialog
}
