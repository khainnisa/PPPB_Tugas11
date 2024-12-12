package com.example.tugaspertemuan11retrofit.network

import com.example.tugaspertemuan11retrofit.model.Users
import retrofit2.Call
import retrofit2.http.GET

// Interface untuk mendefinisikan endpoint API
interface ApiService {
    // Mendefinisikan endpoint GET untuk mengambil data semua pengguna dari API
    @GET("users?page=2")
    fun getAllUsers(): Call<Users>
}
