package com.fefuproject.learningassistant.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.util.*

@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    var uid: String? = UUID.randomUUID().toString(),
    @SerializedName("name")
    var name: String,
    @SerializedName("email")
    var login: String,
    @SerializedName("pass")
    var pass: String,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("phone")
    var phone: String,
    @SerializedName("role")
    var role: String,
    @SerializedName("rating")
    var rating: Double = 0.0
)