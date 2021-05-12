package com.example.testing.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.testing.Repository.ContestRepository

class ContestViewModelFactory(private val ContestRepository: ContestRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ContestViewModel(ContestRepository) as T
    }
}