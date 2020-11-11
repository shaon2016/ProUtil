package com.shaon2016.proutil

import android.app.Activity
import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.Log
import java.text.DateFormat
import java.time.format.DateTimeFormatter
import java.util.*

object DateTimeUtil {
    fun localizedDateFormat(context: Context) {
        val myFormattedDate: String = DateFormat.getDateInstance().format(Date())

        Log.d("DATADATE", myFormattedDate)
    }

    private fun updateResources(context: Context, language: String): Context {
        return Configuration(context.resources.configuration).run {
            Locale.setDefault(Locale(language).also { locale ->
                setLocale(locale)
            }).let {
                context.createConfigurationContext(this)
            }
        }
    }
}