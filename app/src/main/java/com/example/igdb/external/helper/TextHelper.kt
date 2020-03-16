package com.example.igdb.external.helper

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TextHelper @Inject constructor() {
    fun convertLongToFormattedDate(time: Long, format: String): String {
        val date2 = Date(time * 1000)
        val dateFormat = SimpleDateFormat(format, Locale.getDefault())

        return dateFormat.format(date2.time)
    }
}