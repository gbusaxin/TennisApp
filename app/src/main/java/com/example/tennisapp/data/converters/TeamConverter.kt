package com.example.tennisapp.data.converters

import androidx.room.TypeConverter
import com.example.tennisapp.domain.pojo.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*

class TeamConverter {

//    @TypeConverter
//    fun toListTeamsFromJson(teams:String):List<TeamItem>{
//        if(teams == null) return Collections.emptyList()
//        val type:Type = object :TypeToken<List<TeamItem>>(){}.type
//        return Gson().fromJson(teams,type)
//    }
//    @TypeConverter
//    fun fromJsonToListTeams(teamList:List<TeamItem>):String{
//        return Gson().toJson(teamList)
//    }

    @TypeConverter
    fun toListMainInfoFromJson(mainInfo:String):List<MainInfoItem>{
        if(mainInfo == null) return Collections.emptyList()
        val type:Type = object :TypeToken<List<MainInfoItem>>(){}.type
        return Gson().fromJson(mainInfo,type)
    }
    @TypeConverter
    fun fromJsonToListMainInfo(mainInfo:List<MainInfoItem>):String{
        return Gson().toJson(mainInfo)
    }

    @TypeConverter
    fun toListFixturesFromJson(fixtures:String):List<FixtureItem>{
        if(fixtures == null) return Collections.emptyList()
        val type:Type = object :TypeToken<List<FixtureItem>>(){}.type
        return Gson().fromJson(fixtures,type)
    }
    @TypeConverter
    fun fromJsonToListFixtures(fixtures:List<FixtureItem>):String{
        return Gson().toJson(fixtures)
    }

    @TypeConverter
    fun toListPlayersFromJson(players:String):List<PlayerItem>{
        if(players == null) return Collections.emptyList()
        val type:Type = object :TypeToken<List<PlayerItem>>(){}.type
        return Gson().fromJson(players,type)
    }
    @TypeConverter
    fun fromJsonToListPlayers(players:List<PlayerItem>):String{
        return Gson().toJson(players)
    }

    @TypeConverter
    fun toListResultsFromJson(results:String):List<ResultItem>{
        if(results == null) return Collections.emptyList()
        val type:Type = object :TypeToken<List<ResultItem>>(){}.type
        return Gson().fromJson(results,type)
    }
    @TypeConverter
    fun fromJsonToListResults(results:List<ResultItem>):String{
        return Gson().toJson(results)
    }
}