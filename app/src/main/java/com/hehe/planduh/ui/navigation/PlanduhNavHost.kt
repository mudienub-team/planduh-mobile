package com.hehe.planduh.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.hehe.planduh.ui.screens.home.HomeRoute
import com.hehe.planduh.ui.screens.notes.NotesScreen
import com.hehe.planduh.ui.screens.profile.ProfileScreen
import com.hehe.planduh.ui.screens.schedule.ScheduleScreen
import com.hehe.planduh.ui.screens.tasks.TasksScreen

@Composable
fun PlanduhNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = PlanduhTab.Home.route,
        modifier = modifier,
    ) {
        composable(PlanduhTab.Home.route) { HomeRoute() }
        composable(PlanduhTab.Schedule.route) { ScheduleScreen() }
        composable(PlanduhTab.Tasks.route) { TasksScreen() }
        composable(PlanduhTab.Notes.route) { NotesScreen() }
        composable(PlanduhTab.Profile.route) { ProfileScreen() }
    }
}
