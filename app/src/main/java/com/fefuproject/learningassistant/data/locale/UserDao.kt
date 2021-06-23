package com.fefuproject.learningassistant.data.locale

import androidx.lifecycle.LiveData
import androidx.room.*
import com.fefuproject.learningassistant.data.entities.User
import javax.inject.Inject

@Dao
interface UserDao {

    @Query("SELECT * FROM users")
    fun getAllUsers() : LiveData<List<User>>

    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): LiveData<User>

    @Query("SELECT * FROM users WHERE uid = :uid")
    fun getUserUid(uid: Int): LiveData<User>

    @Query("SELECT * FROM users WHERE login = :login")
    fun getUserWithLogin(login: String): LiveData<User>

    @Query("SELECT * FROM users WHERE login = :login AND pass = :pass")
    fun getUserWithLoginAndPass(login: String, pass: String): LiveData<User>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(users: List<User>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: User)

    /*@Update
    fun updateUser(user: User)

    @Delete
    fun delete(user: User)*/

}