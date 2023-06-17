package com.example.eatup.berita_adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.eatup.R

class BeritaAdapter(private val newsList: List<BeritaModel.News>) :
    RecyclerView.Adapter<BeritaAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = view.findViewById(R.id.tvw_photo)
        val titleTextView: TextView = view.findViewById(R.id.tvw_title)
        val descTextView: TextView = view.findViewById(R.id.tvw_Desc)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_berita, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val news = newsList[position]

        holder.imageView.setImageResource(news.photo)
        holder.titleTextView.text = news.title
        holder.descTextView.text = news.desc
    }

    override fun getItemCount(): Int {
        return newsList.size
    }
}
