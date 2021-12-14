package com.example.tennisapp.domain

import androidx.lifecycle.LiveData
import com.example.tennisapp.domain.pojo.TeamItem

interface Repository {
    fun getTeamList(): LiveData<List<TeamItem>>

    fun getTeam(name:String):LiveData<TeamItem>

    suspend fun loadTeamsData()
}