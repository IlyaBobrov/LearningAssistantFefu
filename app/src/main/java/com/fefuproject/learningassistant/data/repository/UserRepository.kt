package com.fefuproject.learningassistant.data.repository

import com.fefuproject.learningassistant.data.locale.UserDao
import com.fefuproject.learningassistant.data.remote.UserRemoteDataSource
import com.fefuproject.learningassistant.utils.performGetOperation
import javax.inject.Inject

class UserRepository
@Inject
constructor(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserDao
) {

    fun getUser(id: Int) =
        performGetOperation(
            databaseQuery = { localDataSource.getUser(id) }
            /*networkCall = { remoteDataSource.getUser(id) },
            saveCallResult = { localDataSource.insert(it) }*/
        )
    fun getUserWithLogin(login: String) =
        performGetOperation(
            databaseQuery = { localDataSource.getUserWithLogin(login) }
            /*networkCall = { remoteDataSource.getUserWithLogin(login) },*/
            /*saveCallResult = { localDataSource.insert(login) }*/
        )

    fun getUserWithLoginAndPass(login: String, pass:String) =
        performGetOperation(
            databaseQuery = { localDataSource.getUserWithLoginAndPass(login,pass) }
            /*networkCall = { remoteDataSource.getUserWithLogin(login) },*/
            /*saveCallResult = { localDataSource.insert(login) }*/
        )

    fun getUsers() =
        performGetOperation(
            databaseQuery = { localDataSource.getAllUsers() }
            /*networkCall = { remoteDataSource.getUsers() },
            saveCallResult = { localDataSource.insertAll(it.results) }*/
        )
}