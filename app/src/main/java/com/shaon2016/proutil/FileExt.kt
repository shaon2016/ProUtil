package com.shaon2016.proutil

import android.os.Environment
import java.io.File
import java.io.FileOutputStream

fun write() {
    val FILENAME = "user_details"
    val name = "suresh"

    val folder: File =
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
    val myFile = File(folder, FILENAME)
    val fstream = FileOutputStream(myFile)
    fstream.write(name.toByteArray())
    fstream.close()
}