package com.hehe.planduh.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.komoui.themes.KomoTheme

/**
 * App theme = KomoUI theme + Soft Indigo palette/radius + our fonts.
 * Typography is applied by re-wrapping MaterialTheme (keeps the colorScheme/shapes KomoTheme set up).
 */
@Composable
fun PlanduhTheme(content: @Composable () -> Unit) {
    KomoTheme(
        komoLightColors = PlanduhLightStyles,
        komoRadius = PlanduhRadius,
    ) {
        MaterialTheme(
            colorScheme = MaterialTheme.colorScheme,
            shapes = MaterialTheme.shapes,
            typography = PlanduhTypography,
            content = content,
        )
    }
}
