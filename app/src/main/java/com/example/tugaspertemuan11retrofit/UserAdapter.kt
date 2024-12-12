package com.example.tugaspertemuan11retrofit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan11retrofit.model.Data
import com.squareup.picasso.Picasso

// Adapter untuk RecyclerView yang bertanggung jawab mengatur tampilan data pengguna
class UserAdapter(private val users: List<Data>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    // ViewHolder untuk merepresentasikan elemen di dalam item layout
    inner class UserViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Komponen-komponen di dalam item_user.xml
        val imgProfile: ImageView = view.findViewById(R.id.img_profile) // Gambar profil
        val txtName: TextView = view.findViewById(R.id.txt_name)       // Nama pengguna
        val txtEmail: TextView = view.findViewById(R.id.txt_email)     // Email pengguna
    }

    // Fungsi untuk membuat ViewHolder baru
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        // Menginflate layout item_user.xml sebagai tampilan item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false)
        return UserViewHolder(view) // Mengembalikan ViewHolder yang sudah dibuat
    }

    // Fungsi untuk mengatur data pada ViewHolder berdasarkan posisi
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position] // Mendapatkan data pengguna berdasarkan posisi
        val fullName = "${user.firstName} ${user.lastName}" // Menggabungkan nama depan dan belakang

        // Mengatur data ke komponen tampilan
        holder.txtName.text = "Name: $fullName"           // Nama lengkap pengguna
        holder.txtEmail.text = "Email: ${user.email}"     // Email pengguna

        // Menggunakan Picasso untuk memuat gambar profil dari URL avatar
        Picasso.get()
            .load(user.avatar) // URL gambar
            .centerCrop()      // Memotong gambar agar sesuai ukuran
            .fit()             // Menyesuaikan ukuran dengan ImageView
            .into(holder.imgProfile) // Memasukkan gambar ke imgProfile

        // Menambahkan aksi ketika nama diklik
        holder.txtName.setOnClickListener {
            val context = holder.itemView.context // Mendapatkan konteks dari item view
            val intent = Intent(context, DetailActivity::class.java) // Membuat intent ke DetailActivity
            // Menambahkan data ke dalam intent
            intent.putExtra("name", fullName)
            intent.putExtra("email", user.email)
            intent.putExtra("avatar", user.avatar)
            context.startActivity(intent) // Memulai DetailActivity
        }
    }

    // Mengembalikan jumlah item dalam daftar
    override fun getItemCount(): Int {
        return users.size
    }
}
