package com.fefuproject.learningassistant.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    var uid: Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("role")
    var role: String,
)