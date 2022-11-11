package com.example.skeletonapp.data.source.local.dao

import androidx.room.Dao
import com.example.skeletonapp.data.source.local.entity.User

@Dao
abstract class UserDao: AppDao<User>("user")