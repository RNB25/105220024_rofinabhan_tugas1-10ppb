package com.example.eatup
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eatup.berita_adapter.BeritaAdapter


class MainActivity : AppCompatActivity() {
    private lateinit var tvwTitle: TextView
    private lateinit var tvwDesc: TextView
    private lateinit var tvwPhoto: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.konten_banyak)
        val layoutManager = LinearLayoutManager(this)
        val adapter = BeritaAdapter(BeritaModel.newsList)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val tambahBeritaButton: Button = findViewById(R.id.fab)
        tambahBeritaButton.setOnClickListener {
            // Membuat objek News baru
            val newNews = BeritaModel.News(
                "Judul Berita Baru",
                "Deskripsi berita baru",
                R.drawable.logo_up
            )

            // Menambahkan berita baru ke BeritaModel
            BeritaModel.addNews(newNews)

            // Memperbarui tampilan RecyclerView dengan berita baru
            adapter.notifyDataSetChanged()
        }
    }
}
