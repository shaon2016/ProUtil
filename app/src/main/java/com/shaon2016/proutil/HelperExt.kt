package com.shaon2016.proutil

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_LONG).show()

fun Context.customToast(msg: String) {
    val toast = Toast(this)
    toast.duration = Toast.LENGTH_LONG

    val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    val view = inflater.inflate(R.layout.custom_toast_layout, null)

    val toastText = view.findViewById<TextView>(R.id.toastText)
    toastText.text = msg

    toast.view = view
    toast.show()
}

fun <T> Context.startActivityNormally(to: Class<T>, extras: Bundle.() -> Unit = {}) =
    startActivity(Intent(this, to).apply {
        putExtras(Bundle().apply(extras))
    })

fun ImageView.load(url: String, placeholder : Int = R.drawable.ic_user) {
    Glide.with(this.context)
        .load(url).apply(
            RequestOptions.placeholderOf(placeholder)
                .error(placeholder)
        )
        .into(this)
}





