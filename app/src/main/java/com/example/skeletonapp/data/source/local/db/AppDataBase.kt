package com.example.skeletonapp.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.skeletonapp.data.source.local.dao.UserDao
import com.example.skeletonapp.data.source.local.entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun flowDao(): UserDao
}
