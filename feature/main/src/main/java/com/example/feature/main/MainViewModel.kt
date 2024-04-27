package com.example.feature.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.UseCase
import com.example.entities.SomeDataEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(private val useCase: UseCase) : ViewModel() {

    private val _state = MutableStateFlow(SomeDataUiModel("Get id"))
    val state: StateFlow<SomeDataUiModel>
        get() = _state

    fun getSomeData() {
        viewModelScope.launch {
            val result = useCase.invoke()
            _state.value = result.map()
        }
    }

    private fun SomeDataEntity.map() = SomeDataUiModel(id = id)
}