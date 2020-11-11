package com.shaon2016.proutil

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

fun <T : ViewModel> AppCompatActivity.obtainViewModel(
    viewModelClass: Class<T>,
    viewmodelFactory: ViewModelProvider.Factory
) =
    ViewModelProvider(this, viewmodelFactory).get(viewModelClass)

fun <T> AppCompatActivity.startActivityNormally(to: Class<T>, extras: Bundle.() -> Unit = {}) =
    startActivity(Intent(this, to).apply {
        putExtras(Bundle().apply(extras))
    })

fun AppCompatActivity.fileChooser(REQUEST_CODE: Int) {
    val intent = Intent(Intent.ACTION_GET_CONTENT);
    intent.type = "*/*";
    startActivityForResult(intent, REQUEST_CODE);
}