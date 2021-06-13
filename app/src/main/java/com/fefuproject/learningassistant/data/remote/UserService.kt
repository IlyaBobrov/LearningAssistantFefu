package com.fefuproject.learningassistant.data.remote

import com.fefuproject.learningassistant.data.entities.User
import com.fefuproject.learningassistant.data.entities.UserList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Part

interface UserService {

    @GET("user")
    suspend fun getAllUsers() : Response<UserList>

    @GET("user/{id}")
    suspend fun getUser(@Part("id")id: Int): Response<User>

}

