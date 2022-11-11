package com.example.skeletonapp.data.source.local.source.user

import com.example.skeletonapp.data.source.local.dao.AppDao
import com.example.skeletonapp.data.source.local.entity.User
import com.example.skeletonapp.data.source.local.source.LocalDataSource

abstract class UserLocalDataSource(dao: AppDao<User>) : LocalDataSource<User>(dao)