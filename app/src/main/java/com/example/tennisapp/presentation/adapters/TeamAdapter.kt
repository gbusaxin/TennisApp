package com.example.tennisapp.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tennisapp.R
import com.example.tennisapp.databinding.ItemTeamBinding
import com.example.tennisapp.domain.pojo.TeamItem
import com.squareup.picasso.Picasso
import java.util.*
import kotlin.collections.ArrayList

class TeamAdapter(var teamList: ArrayList<TeamItem>) :
    RecyclerView.Adapter<TeamAdapter.TeamViewHolder>(), Filterable {
    inner class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemTeamBinding.bind(itemView)
        val image = binding.imageViewTeamImage
        val name = binding.textViewTeamName
    }

    private var filteredList = ArrayList<TeamItem>()

    init {
        filteredList = teamList
    }

    var onTeamClickListener: ((TeamItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_team, parent, false)
        )
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val item = filteredList[position]
        with(holder) {
            Picasso.get().load(item.image).into(image)
            name.text = item.name
        }
        holder.itemView.setOnClickListener {
            onTeamClickListener?.invoke(item)
        }
    }

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    filteredList = teamList
                } else {
                    val result = ArrayList<TeamItem>()
                    for (item in teamList) {
                        if (item.name.lowercase(Locale.ROOT)
                                .trim()
                                .contains(
                                    charSearch.lowercase()
                                        .lowercase(Locale.ROOT)
                                )
                        ) {
                            result.add(item)
                        }
                    }
                    filteredList = result
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as ArrayList<TeamItem>
                notifyDataSetChanged()
            }
        }
    }

}