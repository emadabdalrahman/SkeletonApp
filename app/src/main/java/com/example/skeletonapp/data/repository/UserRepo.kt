package com.example.skeletonapp.data.repository

import com.example.skeletonapp.data.repository.Repository
import com.example.skeletonapp.data.source.local.entity.User
import com.example.skeletonapp.data.source.local.source.user.UserLocalDataSource

class UserRepo(val local: UserLocalDataSource): Repository<User>(local)