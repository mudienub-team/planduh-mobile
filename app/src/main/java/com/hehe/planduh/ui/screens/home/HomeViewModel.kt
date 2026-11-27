package com.hehe.planduh.ui.screens.home

import androidx.lifecycle.ViewModel
import com.hehe.planduh.data.dummy.DummyData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel : ViewModel() {

    // TODO: replace DummyData with a repository once a data source exists.
    private val _uiState = MutableStateFlow(
        buildHomeUiState(
            now = DummyData.now,
            userName = DummyData.USER_NAME,
            periods = DummyData.periods,
            subjects = DummyData.subjects,
            schedules = DummyData.schedules,
            tasks = DummyData.tasks,
        ),
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()
}
