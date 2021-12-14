package com.example.tennisapp.data.database.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.tennisapp.data.database.models.TeamItemDbModel

@Dao
interface TeamDao {

    @Query("SELECT * FROM team_info")
    fun getTeamList():LiveData<List<TeamItemDbModel>>

    @Query("SELECT * FROM team_info WHERE name ==:teamName")
    fun getTeamItem(teamName:String):LiveData<TeamItemDbModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTeamList(teamList:List<TeamItemDbModel>)

}