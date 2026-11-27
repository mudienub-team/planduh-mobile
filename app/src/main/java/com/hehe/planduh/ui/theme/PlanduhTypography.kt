package com.hehe.planduh.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

private fun heading(weight: FontWeight, size: Int, line: Int) =
    TextStyle(fontFamily = PlanduhFonts.Heading, fontWeight = weight, fontSize = size.sp, lineHeight = line.sp, letterSpacing = 0.sp)

private fun body(weight: FontWeight, size: Int, line: Int, spacing: Float = 0f) =
    TextStyle(fontFamily = PlanduhFonts.Body, fontWeight = weight, fontSize = size.sp, lineHeight = line.sp, letterSpacing = spacing.sp)

/** display/headline/title = Plus Jakarta Sans; body/label (incl. button, chip, input) = Inter. */
val PlanduhTypography = Typography(
    displayLarge = heading(FontWeight.ExtraBold, 40, 48),
    displayMedium = heading(FontWeight.ExtraBold, 34, 42),
    displaySmall = heading(FontWeight.Bold, 30, 38),
    headlineLarge = heading(FontWeight.Bold, 28, 36),
    headlineMedium = heading(FontWeight.Bold, 24, 32),   // screen title
    headlineSmall = heading(FontWeight.Bold, 20, 28),
    titleLarge = heading(FontWeight.Bold, 18, 26),
    titleMedium = heading(FontWeight.SemiBold, 16, 24),  // section title
    titleSmall = heading(FontWeight.SemiBold, 14, 20),   // card title
    bodyLarge = body(FontWeight.Normal, 16, 24),
    bodyMedium = body(FontWeight.Normal, 14, 20),
    bodySmall = body(FontWeight.Normal, 12, 16),
    labelLarge = body(FontWeight.SemiBold, 14, 20),      // button
    labelMedium = body(FontWeight.Medium, 12, 16),       // chip
    labelSmall = body(FontWeight.SemiBold, 10, 14, 0.4f),
)

object PlanduhTextStyles {
    /** Label above form fields, rendered uppercase ("MATA PELAJARAN"). */
    val fieldLabel = body(FontWeight.SemiBold, 10, 14, 0.6f)

    /** Detail numbers: stats, times, dates, countdowns (Roboto Mono). */
    val monoLarge = TextStyle(fontFamily = PlanduhFonts.Mono, fontWeight = FontWeight.SemiBold, fontSize = 24.sp, lineHeight = 32.sp)
    val monoMedium = TextStyle(fontFamily = PlanduhFonts.Mono, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp)
    val monoSmall = TextStyle(fontFamily = PlanduhFonts.Mono, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp)
}
