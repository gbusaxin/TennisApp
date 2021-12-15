package com.example.tennisapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tennisapp.R
import com.example.tennisapp.databinding.ItemMatchesBinding
import com.example.tennisapp.domain.pojo.ResultItem
import com.squareup.picasso.Picasso

class ResultAdapter : RecyclerView.Adapter<ResultAdapter.MatchViewHolder>() {
    inner class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemMatchesBinding.bind(itemView)
        val image1 = binding.imageViewEnemy1Image
        val image2 = binding.imageViewEnemy2Image
        val name1 = binding.textViewEnemy1Name
        val name2 = binding.textViewEnemy2Name
        val group = binding.textViewGroup
        val date = binding.textViewDate
        val result = binding.textViewResult
    }

    var list = listOf<ResultItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        return MatchViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_matches, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            Picasso.get().load(item.enemy1Image).into(image1)
            Picasso.get().load(item.enemy2Image).into(image2)
            name1.text = item.enemy1 ?:""
            name2.text = item.enemy2 ?:""
            group.text = item.group ?:"Чемпионат еще не начался"
            date.text = item.date ?:""
            result.text = item.result ?:""
        }
    }

    override fun getItemCount() = list.size
}