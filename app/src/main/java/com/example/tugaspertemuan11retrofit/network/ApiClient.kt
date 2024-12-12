package com.example.tugaspertemuan11retrofit.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getInstance(): ApiService {
        // Membuat interceptor untuk mencatat log HTTP
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)

        // Membuat OkHttpClient dengan menambahkan interceptor logging
        val mOkHttpClient = OkHttpClient
            .Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        // Membuat objek Retrofit dengan konfigurasi dasar
        val builder = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/") // Base URL API
            .addConverterFactory(GsonConverterFactory.create()) // Converter untuk JSON -> Objek Kotlin
            .client(mOkHttpClient) // Menyertakan OkHttpClient yang sudah dibuat
            .build()

        // Menghasilkan instance ApiService (interface API)
        return builder.create(ApiService::class.java)
    }
}
