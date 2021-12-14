package com.example.tennisapp.data.network.retrofit

import com.example.tennisapp.data.network.models.TeamItemDto
import retrofit2.http.GET

interface ApiService {
    @GET("tennis_teams.json")
    suspend fun loadTeamList():List<TeamItemDto>
}