package com.hehe.planduh.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CalendarToday
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.material.icons.outlined.Description
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector

/** One navigation item = one route = one screen. No two items share a route. */
enum class PlanduhTab(val route: String, val label: String, val icon: ImageVector) {
    Home("home", "Beranda", Icons.Outlined.Home),
    Schedule("schedule", "Jadwal", Icons.Outlined.CalendarToday),
    Tasks("tasks", "Tugas", Icons.Outlined.CheckCircle),
    Notes("notes", "Catatan", Icons.Outlined.Description),
    Profile("profile", "Profil", Icons.Outlined.Person);

    companion object {
        fun fromRoute(route: String?): PlanduhTab? = entries.firstOrNull { it.route == route }
    }
}
