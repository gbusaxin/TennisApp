package com.example.tennisapp.domain.use_cases

import com.example.tennisapp.domain.Repository

class GetTeamUseCase(private val repository: Repository) {
    operator fun invoke(name:String) = repository.getTeam(name)
}