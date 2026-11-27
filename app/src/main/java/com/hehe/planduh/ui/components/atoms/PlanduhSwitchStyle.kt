package com.hehe.planduh.ui.components.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hehe.planduh.ui.theme.PlanduhColors
import com.komoui.components.SwitchStyle

/** KomoUI's default off-track uses the (very light) border color; the design wants a visible gray. */
@Composable
fun planduhSwitchColors(): SwitchStyle = SwitchStyle(
    checkedTrack = PlanduhColors.Primary,
    checkedBorder = Color.Transparent,
    checkedThumb = Color.White,
    uncheckedTrack = PlanduhColors.BorderStrong,
    uncheckedBorder = Color.Transparent,
    uncheckedThumb = Color.White,
)
