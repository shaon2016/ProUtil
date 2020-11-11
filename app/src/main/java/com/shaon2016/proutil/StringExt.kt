package com.shaon2016.proutil

fun String.isMobileValid(): Boolean {
    if (!this.isNullOrEmpty() && this.length == 11) {
        val prefix = this.substring(0, 3)
        return prefix == "017" || prefix == "016" || prefix == "018" || prefix == "015" || prefix == "019" || prefix == "013" || prefix == "014"
    }
    return false
}

fun String.englishNumberChangeToBanglaNumber(): String {
    val hash = HashMap<Int, String>()
    hash[0] = "০"
    hash[1] = "১"
    hash[2] = "২"
    hash[3] = "৩"
    hash[4] = "৪"
    hash[5] = "৫"
    hash[6] = "৬"
    hash[7] = "৭"
    hash[8] = "৮"
    hash[9] = "৯"
    var banglaDate = ""
    this.forEach {
        try {
            val digit = it.toString().toInt()
            banglaDate += hash[digit]
        } catch (e: Exception) {
            banglaDate += it
        }
    }
    return banglaDate
}