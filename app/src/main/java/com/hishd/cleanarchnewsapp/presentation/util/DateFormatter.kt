package com.hishd.cleanarchnewsapp.presentation.util

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {
    fun format(pattern: String, date: String): String {
        return SimpleDateFormat(pattern).format(date)
    }

    fun format(pattern: String, date: Date): String {
        return SimpleDateFormat(pattern).format(date)
    }
}