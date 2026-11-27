package com.hehe.planduh.ui.theme

import androidx.compose.ui.graphics.Color

/** Status color pair (container + content), used by badges and indicators. */
enum class StatusTone(val container: Color, val content: Color) {
    Neutral(PlanduhColors.SurfaceMuted, PlanduhColors.TextSecondary),
    Primary(PlanduhColors.PrimaryLight, PlanduhColors.PrimaryDark),
    Success(PlanduhColors.SuccessContainer, PlanduhColors.OnSuccessContainer),
    Warning(PlanduhColors.WarningContainer, PlanduhColors.OnWarningContainer),
    Error(PlanduhColors.ErrorContainer, PlanduhColors.OnErrorContainer),
    Info(PlanduhColors.InfoContainer, PlanduhColors.OnInfoContainer),
}
