package com.hehe.planduh.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import com.komoui.themes.BoxShadow
import com.komoui.themes.KomoRadius
import com.komoui.themes.KomoStyles

/** Maps the Soft Indigo Planner palette onto KomoUI's shadcn-style tokens. */
object PlanduhLightStyles : KomoStyles {
    override val background: Color = PlanduhColors.Background
    override val foreground: Color = PlanduhColors.TextPrimary
    override val card: Color = PlanduhColors.Surface
    override val cardForeground: Color = PlanduhColors.TextPrimary
    override val popover: Color = PlanduhColors.Surface
    override val popoverForeground: Color = PlanduhColors.TextPrimary
    override val primary: Color = PlanduhColors.Primary
    override val primaryForeground: Color = PlanduhColors.TextInverse
    override val secondary: Color = PlanduhColors.PrimaryLight
    override val secondaryForeground: Color = PlanduhColors.PrimaryDark
    override val muted: Color = PlanduhColors.SurfaceMuted
    override val mutedForeground: Color = PlanduhColors.TextSecondary
    override val accent: Color = PlanduhColors.PrimaryLight
    override val accentForeground: Color = PlanduhColors.PrimaryDark
    override val destructive: Color = PlanduhColors.Error
    override val destructiveForeground: Color = PlanduhColors.TextInverse
    override val border: Color = PlanduhColors.Border
    override val input: Color = PlanduhColors.Border
    override val ring: Color = PlanduhColors.Primary
    override val chart1: Color = SubjectPalette.Blue.solid
    override val chart2: Color = SubjectPalette.Green.solid
    override val chart3: Color = SubjectPalette.Orange.solid
    override val chart4: Color = SubjectPalette.Pink.solid
    override val chart5: Color = SubjectPalette.Purple.solid
    override val sidebar: Color = PlanduhColors.Surface
    override val sidebarForeground: Color = PlanduhColors.TextPrimary
    override val sidebarPrimary: Color = PlanduhColors.Primary
    override val sidebarPrimaryForeground: Color = PlanduhColors.TextInverse
    override val sidebarAccent: Color = PlanduhColors.PrimaryLight
    override val sidebarAccentForeground: Color = PlanduhColors.PrimaryDark
    override val sidebarBorder: Color = PlanduhColors.Border
    override val sidebarRing: Color = PlanduhColors.Primary
    override val snackbar: Color = PlanduhColors.Surface

    // Shadows: Tailwind v4 values.
    @Composable
    override fun shadow2xs() = listOf(tw(y = 1, blur = 0, spread = 0, alpha = 0.05f))

    @Composable
    override fun shadowXs() = listOf(tw(y = 1, blur = 2, spread = 0, alpha = 0.05f))

    @Composable
    override fun shadowSm() = TW_SM

    @Composable
    override fun shadow() = TW_SM   // Tailwind's default "shadow" == sm

    @Composable
    override fun shadowMd() = listOf(
        tw(y = 4, blur = 6, spread = -1, alpha = 0.1f),
        tw(y = 2, blur = 4, spread = -2, alpha = 0.1f),
    )

    @Composable
    override fun shadowLg() = listOf(
        tw(y = 10, blur = 15, spread = -3, alpha = 0.1f),
        tw(y = 4, blur = 6, spread = -4, alpha = 0.1f),
    )

    @Composable
    override fun shadowXl() = listOf(
        tw(y = 20, blur = 25, spread = -5, alpha = 0.1f),
        tw(y = 8, blur = 10, spread = -6, alpha = 0.1f),
    )

    @Composable
    override fun shadow2xl() = listOf(tw(y = 25, blur = 50, spread = -12, alpha = 0.25f))
}

private val TW_SM = listOf(
    tw(y = 1, blur = 3, spread = 0, alpha = 0.1f),
    tw(y = 1, blur = 2, spread = -1, alpha = 0.1f),
)

/** Tailwind "0 {y}px {blur}px {spread}px rgb(0 0 0 / alpha)". x offset is always 0 in Tailwind. */
private fun tw(y: Int, blur: Int, spread: Int, alpha: Float) = BoxShadow(
    color = Color.Black.copy(alpha = alpha),
    offsetX = 0.dp,
    offsetY = y.dp,
    blurRadius = blur.dp,
    spread = spread.dp,
)

/** Buttons/inputs -> md (12dp), cards -> lg (14dp). */
object PlanduhRadius : KomoRadius {
    override val radius: Dp = 14.dp
    override val sm: Dp = max(0.dp, radius - 4.dp)
    override val md: Dp = max(0.dp, radius - 2.dp)
    override val lg: Dp = radius
    override val xl: Dp = max(0.dp, radius + 4.dp)
    override val xxl: Dp = max(0.dp, radius + 8.dp)
    override val xl3: Dp = max(0.dp, radius + 12.dp)
    override val full: Dp = 999.dp
}