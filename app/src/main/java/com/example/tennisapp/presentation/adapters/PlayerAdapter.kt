package com.example.tennisapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tennisapp.R
import com.example.tennisapp.databinding.ItemPlayerBinding
import com.example.tennisapp.domain.pojo.PlayerItem
import com.squareup.picasso.Picasso

class PlayerAdapter : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPlayerBinding.bind(itemView)
        val imagePlayer = binding.imageViewPlayerImage
        val imageCountry = binding.imageViewPlayerImageCountry
        val namePlayer = binding.textViewPlayerName
        val birthdayPlayer = binding.textViewPlayerBirthday
        val heightPlayer = binding.textViewPlayerHeight
        val weightPlayer = binding.textViewPlayerWeight
    }

    var list = listOf<PlayerItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_player, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val item = list[position]
        with(holder) {
            Picasso.get().load(item.imagePlayer).into(imagePlayer)
            Picasso.get().load(item.imageCountry).into(imageCountry)
            namePlayer.text = item.name
            birthdayPlayer.text = item.birthday
            heightPlayer.text = item.height
            weightPlayer.text = item.weight
        }
    }

    override fun getItemCount() = list.size
}