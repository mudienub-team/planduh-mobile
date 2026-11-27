package com.hehe.planduh.ui.theme

import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import com.hehe.planduh.R

/**
 * Heading -> Plus Jakarta Sans
 * Body, Button, Form & Input -> Inter
 * Detail numbers -> Roboto Mono
 * Bundled variable fonts (res/font); minSdk 29 supports variable fonts.
 */
@OptIn(ExperimentalTextApi::class)
private fun variableFamily(resId: Int, vararg weights: FontWeight): FontFamily =
    FontFamily(
        weights.map { w ->
            Font(resId = resId, weight = w, variationSettings = FontVariation.Settings(FontVariation.weight(w.weight)))
        }
    )

object PlanduhFonts {
    val Heading = variableFamily(R.font.plus_jakarta_sans_variable, FontWeight.Medium, FontWeight.SemiBold, FontWeight.Bold, FontWeight.ExtraBold)
    val Body = variableFamily(R.font.inter_variable, FontWeight.Normal, FontWeight.Medium, FontWeight.SemiBold, FontWeight.Bold)
    val Mono = variableFamily(R.font.roboto_mono_variable, FontWeight.Normal, FontWeight.Medium, FontWeight.SemiBold, FontWeight.Bold)
}
