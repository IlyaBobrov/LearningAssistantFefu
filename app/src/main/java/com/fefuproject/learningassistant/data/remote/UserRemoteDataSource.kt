package com.fefuproject.learningassistant.data.remote

import javax.inject.Inject

class UserRemoteDataSource
@Inject public
constructor(
    private val userService: UserService
) : BaseDataSource() {

    suspend fun getUsers() =
        getResult {
            userService.getAllUsers()
        }

    suspend fun getUser(id: Int) =
        getResult {
            userService.getUser(id)
        }
}