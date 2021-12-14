package com.example.tennisapp.domain.use_cases

import com.example.tennisapp.domain.Repository

class LoadTeamsDataUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadTeamsData()
}