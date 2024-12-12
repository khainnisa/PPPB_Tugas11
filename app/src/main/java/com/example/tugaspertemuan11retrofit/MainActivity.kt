package com.example.tugaspertemuan11retrofit

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tugaspertemuan11retrofit.databinding.ActivityMainBinding
import com.example.tugaspertemuan11retrofit.model.Users
import com.example.tugaspertemuan11retrofit.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

// Kelas MainActivity yang digunakan sebagai entry point aplikasi
class MainActivity : AppCompatActivity() {

    // Binding untuk menghubungkan view di XML dengan kode tanpa menggunakan findViewById
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Menginisialisasi binding dengan menggunakan layout inflater
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root) // Mengatur tampilan utama dari aktivitas ke binding root

        // Mengatur layout manager untuk RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Memanggil fungsi untuk mengambil data pengguna dari API
        fetchUsers()
    }

    // Fungsi untuk mengambil data pengguna dari API menggunakan Retrofit
    private fun fetchUsers() {
        // Mendapatkan instance dari ApiClient untuk memanggil endpoint API
        val apiClient = ApiClient.getInstance()
        val call = apiClient.getAllUsers()

        // Melakukan request API secara asynchronous
        call.enqueue(object : Callback<Users> {
            // Fungsi callback ketika response dari server diterima
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                if (response.isSuccessful) { // Jika response sukses (kode HTTP 200-299)
                    val users = response.body()?.data ?: emptyList() // Ambil data pengguna dari response
                    binding.recyclerView.adapter = UserAdapter(users) // Set adapter untuk RecyclerView
                } else {
                    // Tampilkan pesan kesalahan jika response tidak sukses
                    Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
                }
            }

            // Fungsi callback ketika request gagal, misalnya karena tidak ada koneksi internet
            override fun onFailure(call: Call<Users>, t: Throwable) {
                // Tampilkan pesan kesalahan dengan informasi dari Throwable
                Toast.makeText(this@MainActivity, "Error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
