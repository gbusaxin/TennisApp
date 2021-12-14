package com.example.tennisapp.data.network.models

import com.example.tennisapp.domain.pojo.FixtureItem
import com.example.tennisapp.domain.pojo.MainInfoItem
import com.example.tennisapp.domain.pojo.PlayerItem
import com.example.tennisapp.domain.pojo.ResultItem
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class TeamItemDto {
    @SerializedName("name")
    @Expose
    val name: String? = null

    @SerializedName("image")
    @Expose
    val image: String? = null

    @SerializedName("mainInfo")
    @Expose
    val mainInfo: List<MainInfoItem>? = null

    @SerializedName("fixtures")
    @Expose
    val fixtures: List<FixtureItem>? = null

    @SerializedName("players")
    @Expose
    val players: List<PlayerItem>? = null

    @SerializedName("results")
    @Expose
    val results: List<ResultItem>? = null

}