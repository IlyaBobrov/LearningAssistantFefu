package com.fefuproject.learningassistant.data.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity(tableName = "materials")
@Parcelize
data class MatetialModel(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int,
    @SerializedName("uid")
    var uid: String? = UUID.randomUUID().toString(),
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
) : Parcelable