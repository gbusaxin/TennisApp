package com.example.tennisapp.data.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.tennisapp.data.converters.TeamConverter
import com.example.tennisapp.domain.pojo.FixtureItem
import com.example.tennisapp.domain.pojo.MainInfoItem
import com.example.tennisapp.domain.pojo.PlayerItem
import com.example.tennisapp.domain.pojo.ResultItem

@Entity(tableName = "team_info")
@TypeConverters(TeamConverter::class)
data class TeamItemDbModel (

    @PrimaryKey
    val name: String,


    val image: String,


    val mainInfo: List<MainInfoItem>,


    val fixtures: List<FixtureItem>,


    val players: List<PlayerItem>,


    val results: List<ResultItem>

)