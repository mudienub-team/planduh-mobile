package com.hehe.planduh.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.hehe.planduh.ui.components.organisms.PlanduhBottomBar
import com.hehe.planduh.ui.navigation.LocalNavController
import com.hehe.planduh.ui.navigation.PlanduhNavHost
import com.hehe.planduh.ui.navigation.PlanduhTab
import com.hehe.planduh.ui.navigation.navTo
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.PlanduhTheme

/** App root: theme + scaffold (bottom bar) + NavHost. */
@Composable
fun PlanduhApp() {
    PlanduhTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val selectedTab = PlanduhTab.fromRoute(backStackEntry?.destination?.route) ?: PlanduhTab.Home

        CompositionLocalProvider(LocalNavController provides navController) {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = PlanduhColors.Background,
                bottomBar = { PlanduhBottomBar(selected = selectedTab, onSelect = { navController.navTo(it) }) },
            ) { innerPadding ->
                PlanduhNavHost(navController, Modifier.padding(innerPadding))
            }
        }
    }
}
