package com.example.tennisapp.domain.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class TeamItem (

     val name: String,


     val image: String,


     val mainInfo: List<MainInfoItem>,


     val fixtures: List<FixtureItem>,


     val players: List<PlayerItem>,


     val results: List<ResultItem>
)