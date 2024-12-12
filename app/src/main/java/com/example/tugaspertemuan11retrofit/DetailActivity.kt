package com.example.tugaspertemuan11retrofit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

// Activity untuk menampilkan detail pengguna
class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail) // Menggunakan layout activity_detail.xml

        // Inisialisasi komponen View dari layout
        val imgProfile: ImageView = findViewById(R.id.img_profile) // Gambar profil
        val txtName: TextView = findViewById(R.id.txt_name)         // Nama pengguna
        val txtEmail: TextView = findViewById(R.id.txt_email)       // Email pengguna

        // Mengambil data yang dikirimkan melalui intent
        val name = intent.getStringExtra("name")    // Mengambil nama
        val email = intent.getStringExtra("email")  // Mengambil email
        val avatar = intent.getStringExtra("avatar") // Mengambil URL avatar

        // Menampilkan data ke tampilan
        txtName.text = "Name: $name"      // Menampilkan nama pada TextView txtName
        txtEmail.text = "Email: $email"  // Menampilkan email pada TextView txtEmail

        // Memuat gambar avatar ke ImageView menggunakan Picasso
        Picasso.get()
            .load(avatar) // URL gambar dari intent
            .centerCrop()  // Memotong gambar agar sesuai ukuran
            .fit()         // Menyesuaikan gambar dengan ImageView
            .into(imgProfile) // Memasukkan gambar ke imgProfile
    }
}
