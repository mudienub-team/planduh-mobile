package com.hehe.planduh.ui.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.hehe.planduh.data.dummy.DummyData
import com.hehe.planduh.ui.components.molecules.ScheduleItem
import com.hehe.planduh.ui.components.molecules.SectionHeader
import com.hehe.planduh.ui.components.molecules.TaskItem
import com.hehe.planduh.ui.components.molecules.WeekDayItem
import com.hehe.planduh.ui.components.organisms.HomeHeader
import com.hehe.planduh.ui.components.organisms.NextClassCard
import com.hehe.planduh.ui.navigation.LocalNavController
import com.hehe.planduh.ui.navigation.PlanduhTab
import com.hehe.planduh.ui.navigation.navTo
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.PlanduhTheme

/** Connects the ViewModel to the screen. The screen itself (HomeScreen) is stateless. */
@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(),
) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state, modifier)
}

@Composable
fun HomeScreen(state: HomeUiState, modifier: Modifier = Modifier) {
    val nav = LocalNavController.current

    Column(
        modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
    ) {
        HomeHeader(
            userName = state.userName,
            dateText = state.dateText,
            hasUnreadNotification = state.hasUnreadNotification,
        )

        state.nextClass?.let {
            NextClassCard(
                subjectName = it.subjectName,
                timeRangeText = it.timeRangeText,
                countdownText = it.countdownText,
            )
        }

        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            SectionHeader(
                "Jadwal Hari Ini",
                actionLabel = "Lihat mingguan",
                onActionClick = { nav?.navTo(PlanduhTab.Schedule) },
            )
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                state.weekDays.forEach {
                    WeekDayItem(
                        dayLabel = it.label,
                        dateNumber = it.dateNumber,
                        selected = it.isSelected,
                        modifier = Modifier.weight(1f),
                    )
                }
            }
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                state.schedules.forEach {
                    ScheduleItem(
                        startTime = it.startTime,
                        endTime = it.endTime,
                        title = it.subjectName,
                        room = it.room,
                        subjectColor = it.color,
                        status = it.status,
                    )
                }
            }
        }

        if (state.tasks.isNotEmpty()) {
            Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                SectionHeader(
                    "Tugas Terdekat",
                    actionLabel = "Semua",
                    onActionClick = { nav?.navTo(PlanduhTab.Tasks) },
                )
                state.tasks.forEach { TaskItem(title = it.title, deadlineText = it.deadlineText) }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF6F6FB, heightDp = 900)
@Composable
private fun HomeScreenPreview() {
    PlanduhTheme {
        HomeScreen(
            buildHomeUiState(
                now = DummyData.now,
                userName = DummyData.USER_NAME,
                periods = DummyData.periods,
                subjects = DummyData.subjects,
                schedules = DummyData.schedules,
                tasks = DummyData.tasks,
            ),
        )
    }
}
