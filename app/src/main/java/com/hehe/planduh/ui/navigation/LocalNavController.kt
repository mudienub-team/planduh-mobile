package com.hehe.planduh.ui.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController

/**
 * Gives any screen access to the app's NavController without passing it down as a parameter.
 * Null by default so @Preview and tests do not crash; navigation is simply a no-op there.
 */
val LocalNavController = compositionLocalOf<NavHostController?> { null }
