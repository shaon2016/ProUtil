package com.shaon2016.proutil

import android.content.Context
import android.content.Intent
import android.net.Uri


fun Intent.dialUp(context: Context, m: String) {
    action = Intent.ACTION_DIAL
    data = Uri.parse("tel: $m")
    context.startActivity(this)
}

