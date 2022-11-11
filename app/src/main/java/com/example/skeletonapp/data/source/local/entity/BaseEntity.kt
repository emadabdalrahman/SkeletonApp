package com.example.skeletonapp.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.*

open class BaseEntity(
    @ColumnInfo(name = "id") @PrimaryKey val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "created_at") internal val createdAt: Instant? = null,
    @ColumnInfo(name = "updated_at") internal val updatedAt: Instant? = null,
    @ColumnInfo(name = "deleted_at") internal val deletedAt: Instant? = null
)
