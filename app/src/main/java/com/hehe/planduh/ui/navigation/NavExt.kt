package com.hehe.planduh.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/** Go to a bottom-bar tab: no back stack buildup, and each tab keeps its saved state. */
fun NavHostController.navTo(tab: PlanduhTab) {
    navigate(tab.route) {
        popUpTo(graph.findStartDestination().id) { saveState = true }
        launchSingleTop = true
        restoreState = true
    }
}

/** Go to a screen outside the bottom bar. Back returns to the previous screen. */
fun NavHostController.navTo(route: String) {
    navigate(route) { launchSingleTop = true }
}

/** Go back one screen. */
fun NavHostController.navBack() {
    popBackStack()
}
