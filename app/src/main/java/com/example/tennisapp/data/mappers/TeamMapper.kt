package com.example.tennisapp.data.mappers

import com.example.tennisapp.data.database.models.TeamItemDbModel
import com.example.tennisapp.data.network.models.TeamItemDto
import com.example.tennisapp.domain.pojo.TeamItem
import java.util.*

class TeamMapper {

    fun mapDbModelToEntity(dbModel: TeamItemDbModel) = TeamItem(
        name = dbModel.name,
        image = dbModel.image,
        mainInfo = dbModel.mainInfo,
        fixtures = dbModel.fixtures,
        players = dbModel.players,
        results = dbModel.results
    )

    fun mapDtoToDbModel(dto: TeamItemDto) = TeamItemDbModel(
        name = dto.name?:"",
        image = dto.image?:"",
        mainInfo = dto.mainInfo?: Collections.emptyList(),
        fixtures = dto.fixtures?: Collections.emptyList(),
        players = dto.players?: Collections.emptyList(),
        results = dto.results?: Collections.emptyList()
    )
}