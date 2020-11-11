package com.shaon2016.proutil

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner


fun <T : ViewModel> Fragment.obtainViewModel(
    viewModelClass: Class<T>,
    viewmodelFactory: ViewModelProvider.Factory
) =
    ViewModelProvider(this, viewmodelFactory).get(viewModelClass)


fun <T : ViewModel> obtainViewModel(owner: ViewModelStoreOwner,
    viewModelClass: Class<T>,
    viewmodelFactory: ViewModelProvider.Factory
) =
    ViewModelProvider(owner, viewmodelFactory).get(viewModelClass)

fun Fragment.fileChooser(REQUEST_CODE: Int) {
    val intent = Intent(Intent.ACTION_GET_CONTENT);
    intent.type = "*/*";
    startActivityForResult(intent, REQUEST_CODE);
}

fun <T> Fragment.startActivityNormally(to: Class<T>, extras: Bundle.() -> Unit = {}) =
    startActivity(Intent(requireContext(), to).apply {
        putExtras(Bundle().apply(extras))
    })