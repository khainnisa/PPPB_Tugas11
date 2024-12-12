package com.example.tugaspertemuan11retrofit.model

import com.google.gson.annotations.SerializedName

data class Users(
    @SerializedName("data") // Memberikan nama JSON yang sesuai untuk mapping
    val `data`: List<Data> // Menggunakan backtick (`) karena "data" adalah kata kunci Kotlin
)
