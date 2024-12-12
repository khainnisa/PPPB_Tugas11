package com.example.tugaspertemuan11retrofit.model

import com.google.gson.annotations.SerializedName

data class Data (
    @SerializedName("id")
    val id: Int, // ID unik untuk setiap pengguna
    @SerializedName("email")
    val email: String, // Alamat email pengguna
    @SerializedName("first_name")
    val firstName: String, // Nama depan pengguna
    @SerializedName("last_name")
    val lastName: String, // Nama belakang pengguna
    @SerializedName("avatar")
    val avatar: String // URL gambar avatar pengguna
)
