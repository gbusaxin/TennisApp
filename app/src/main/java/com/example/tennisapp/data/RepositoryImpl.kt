package com.example.tennisapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.tennisapp.data.database.db.TeamDatabase
import com.example.tennisapp.data.mappers.TeamMapper
import com.example.tennisapp.data.network.retrofit.ApiFactory
import com.example.tennisapp.domain.Repository
import com.example.tennisapp.domain.pojo.TeamItem

class RepositoryImpl(private val application: Application):Repository {

    private val dao = TeamDatabase.getInstance(application).teamDao()
    private val apiService = ApiFactory.apiService
    private val teamMapper = TeamMapper()

    override fun getTeamList(): LiveData<List<TeamItem>> {
        return Transformations.map(dao.getTeamList()){
            it.map{teamMapper.mapDbModelToEntity(it)}
        }
    }

    override fun getTeam(name: String): LiveData<TeamItem> {
        return Transformations.map(dao.getTeamItem(name)){
            teamMapper.mapDbModelToEntity(it)
        }
    }

    override suspend fun loadTeamsData() {
        try {
            val dto = apiService.loadTeamList()
            val dbModel = dto.map { teamMapper.mapDtoToDbModel(it) }
            dao.insertTeamList(dbModel)
        }catch (e:Exception){}
    }
}