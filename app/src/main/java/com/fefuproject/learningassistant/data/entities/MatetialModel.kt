package com.fefuproject.learningassistant.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

//@Entity(tableName = "users")
data class MatetialModel(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    var uid: Int,
    @SerializedName("heading")
    var heading: String,
    @SerializedName("subject")
    var subject: String,
    @SerializedName("text")
    var text: String,
    @SerializedName("image")
    var image: String? = null,
    @SerializedName("url")
    var url: String? = null,

)