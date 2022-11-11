package com.example.skeletonapp.data.source.local.source.user

import com.example.skeletonapp.data.source.local.dao.UserDao

class UserLocalDataSourceImpl(private val dao: UserDao) : UserLocalDataSource(dao)