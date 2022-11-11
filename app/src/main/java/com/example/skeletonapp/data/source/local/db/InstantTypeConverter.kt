package com.example.skeletonapp.data.source.local.db

import androidx.room.TypeConverter
import java.time.Instant
import java.time.LocalDateTime
import java.time.OffsetTime
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

object InstantTypeConverter {

    @TypeConverter
    @JvmStatic
    fun toInstant(value: String): Instant {
        return LocalDateTime.parse(
            value,
            DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss")
                .withZone(ZoneOffset.UTC)
        ).toInstant(ZoneOffset.UTC)
    }

    @TypeConverter
    @JvmStatic
    fun fromInstant(date: Instant): String {
        return DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneOffset.UTC)
            .format(date)
    }
}