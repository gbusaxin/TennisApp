package com.example.tennisapp.presentation.activities

import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition
import com.example.tennisapp.data.network.retrofit.ApiFactory
import com.example.tennisapp.databinding.ActivityMainBinding
import com.example.tennisapp.domain.pojo.TeamItem
import com.example.tennisapp.presentation.AppViewModel
import com.example.tennisapp.presentation.adapters.TeamAdapter


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var adapter: TeamAdapter
    lateinit var viewModel: AppViewModel
    private val apiService = ApiFactory.apiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadJsonPicture()

        val rvTeam = binding.rvTeams
        val searchView = binding.searchViewTeams

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        viewModel.teamList.observe(this, {
            adapter = TeamAdapter(it as ArrayList<TeamItem>)
            rvTeam.adapter = adapter
            Log.d("CHECK_DATA",it.toString())

            adapter.onTeamClickListener = {
                val intent = Intent(this@MainActivity, NavigationActivity::class.java)
                val selectedTeam = it.name
                intent.putExtra("selectedTeam", selectedTeam)
                startActivity(intent)
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
        })

    }

    private fun loadJsonPicture(){
        Glide.with(this).load("http://95.217.132.144/tennis/background_image.jpg")
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(dr: Drawable, tran: Transition<in Drawable?>?) {
                    binding.mainActivityLayout.background = dr
                }
            })
    }
}

