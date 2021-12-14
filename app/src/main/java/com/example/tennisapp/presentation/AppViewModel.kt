package com.example.tennisapp.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tennisapp.data.RepositoryImpl
import com.example.tennisapp.domain.use_cases.GetTeamListUseCase
import com.example.tennisapp.domain.use_cases.GetTeamUseCase
import com.example.tennisapp.domain.use_cases.LoadTeamsDataUseCase
import kotlinx.coroutines.launch

class AppViewModel(application: Application): AndroidViewModel(application){
    private val repository = RepositoryImpl(application)

    private val getTeamListUseCase = GetTeamListUseCase(repository)
    private val getTeamUseCase = GetTeamUseCase(repository)
    private val loadTeamUseCase = LoadTeamsDataUseCase(repository)

    val teamList = getTeamListUseCase()

    fun getTeamItem(name:String) = getTeamUseCase(name)

    init {
        viewModelScope.launch {
            loadTeamUseCase()
        }
    }


}