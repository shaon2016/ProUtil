package com.shaon2016.proutil

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.view.setPadding
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.shaon2016.proutil.databinding.CustomSpinnerDialogBinding
import kotlinx.android.synthetic.main.dialog_progress.view.*

object D {

    inline fun showSpinnerDialog(
        context: Context,
        title: String,
        rv: (RecyclerView, Dialog) -> Unit
    ) {
        val newDialog = Dialog(context, R.style.customDialog)
        newDialog.requestWindowFeature(android.view.Window.FEATURE_NO_TITLE)
        newDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val customDialogBinding: CustomSpinnerDialogBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.custom_spinner_dialog, null, false
        )

        newDialog.setContentView(customDialogBinding.root)

        rv(customDialogBinding.recyclerView2, newDialog)

        customDialogBinding.textView92.text = title

        customDialogBinding.done.setOnClickListener {
            newDialog.dismiss()
        }
        customDialogBinding.cancel.setOnClickListener {
            newDialog.dismiss()
        }

        newDialog.show()
        newDialog.setCancelable(false)
    }

    fun showProgressDialog(
        context: Context,
        msg: String = context.getString(R.string.please_wait),
        isCancelable: Boolean = false
    ): Dialog {

        val v = View.inflate(context, R.layout.dialog_progress, null)

        val d = Dialog(context, R.style.Theme_AppCompat_Dialog_Alert)
        d.setContentView(v)
        d.setCancelable(isCancelable)

        v.tvMsg.text = msg

        return d
    }

    fun showNormalAlertDialog(
        context: Context,
        msg: String,
        isCancelable: Boolean = true
    ) {

        val layout = RelativeLayout(context)
        layout.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layout.gravity = Gravity.CENTER
        layout.setPadding(16)

        val tv = TextView(context)
        tv.text = msg
        tv.gravity = Gravity.CENTER
        tv.setPadding(16)

        layout.addView(tv)

        AlertDialog.Builder(context)
            .setView(layout)
            .setCancelable(isCancelable)
            .create()
            .show()
    }

    fun simplePositiveActionDialog(
        context: Context,
        msg: String,
        isCancelable: Boolean = true,
        completionHandler: ((dialog: DialogInterface) -> Unit)? = null
    ) {
        AlertDialog.Builder(context)
            .setMessage(msg)
            .setCancelable(isCancelable)
            .setPositiveButton(
                context.getString(R.string.ok)
            ) { dialog, which ->
                completionHandler?.let { it(dialog) }
            }
            .setNegativeButton(context.getString(R.string.cancel)) { dialog, which ->
                dialog.dismiss()
            }
            .create()
            .show()
    }
    fun simplePositiveNegativeActionDialog(
        context: Context,
        msg: String,
        isCancelable: Boolean = true,
        positiveHandler: ((dialog: DialogInterface) -> Unit)? = null,
        negativeHandler: ((dialog: DialogInterface) -> Unit)? = null
    ) {
        AlertDialog.Builder(context)
            .setMessage(msg)
            .setCancelable(isCancelable)
            .setPositiveButton(
                context.getString(R.string.ok)
            ) { dialog, which ->
                positiveHandler?.let { it(dialog) }
            }
            .setNegativeButton(context.getString(R.string.cancel)) { dialog, which ->
                negativeHandler?.let { it(dialog) }
            }
            .create()
            .show()
    }

    fun showSnackLongMsg(activity: Activity, message: String) {
        try {
            Snackbar.make(
                activity.findViewById(android.R.id.content), message,
                Snackbar.LENGTH_LONG
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
    fun showSnackInfiniteMsg(activity: Activity, message: String) {
        try {
            Snackbar.make(
                activity.findViewById(android.R.id.content), message,
                Snackbar.LENGTH_INDEFINITE
            ).show()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}