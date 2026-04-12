package com.sampe.cmp.app.utils

import kotlin.time.Clock
import kotlin.time.Instant

object DateTimeUtils {
    fun getRelativeTime(timestamp: Long): String {
        val now = Clock.System.now()
        val past = Instant.fromEpochMilliseconds(timestamp)

        val diff = now.toEpochMilliseconds() - past.toEpochMilliseconds()

        val seconds = diff / 1000
        val minutes = seconds / 60
        val hours = minutes / 60
        val days = hours / 24

        return when {
            seconds < 60 -> "Just now"
            minutes < 60 -> "$minutes minutes ago"
            hours < 24 -> "$hours hours ago"
            days < 7 -> "$days days ago"
            else -> "${days / 7} weeks ago"
        }
    }
}