package com.example.tennisapp.domain.use_cases

import com.example.tennisapp.domain.Repository

class GetTeamListUseCase(private val repository: Repository) {
    operator fun invoke() = repository.getTeamList()
}