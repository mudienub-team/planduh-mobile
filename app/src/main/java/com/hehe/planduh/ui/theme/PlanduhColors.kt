package com.hehe.planduh.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

/**
 * Soft Indigo Planner palette (source of truth).
 * Values marked "derived" are not in the palette spec; they are tints/shades derived from it.
 */
object PlanduhColors {
    // Primary
    val Primary = Color(0xFF5B55DF)
    val PrimaryDark = Color(0xFF4842C5)     // pressed / hover
    val PrimaryLight = Color(0xFFEAE9FF)    // selected background
    val Background = Color(0xFFF6F6FB)
    val Surface = Color(0xFFFFFFFF)
    val Border = Color(0xFFEAEAF1)

    // Text
    val TextPrimary = Color(0xFF202033)
    val TextSecondary = Color(0xFF85859A)
    val TextMuted = Color(0xFFB0B0C0)
    val TextInverse = Color(0xFFFFFFFF)

    // Status
    val Success = Color(0xFF39C99A)
    val Warning = Color(0xFFFFA34D)
    val Error = Color(0xFFF47785)
    val Info = Color(0xFF5B91F7)

    // Derived
    val SurfaceMuted = Color(0xFFF0F0F7)
    val BorderStrong = Color(0xFFD3D3E0)    // switch track off, strong borders
    val SuccessContainer = Color(0xFFDDF6EC)
    val OnSuccessContainer = Color(0xFF1C8A66)
    val WarningContainer = Color(0xFFFFF0DA)
    val OnWarningContainer = Color(0xFFB86A10)
    val ErrorContainer = Color(0xFFFEE8EB)
    val OnErrorContainer = Color(0xFFC23A4A)
    val InfoContainer = Color(0xFFE4EEFE)
    val OnInfoContainer = Color(0xFF2753B8)
}

/** Color set for a school subject / category (calendar blocks, badges, task accents). */
@Immutable
class SubjectColor(val solid: Color, val container: Color, val content: Color)

object SubjectPalette {
    val Blue = SubjectColor(Color(0xFF5B91F7), Color(0xFFE4EEFE), Color(0xFF2753B8))
    val Green = SubjectColor(Color(0xFF39C99A), Color(0xFFDDF6EC), Color(0xFF1C8A66))
    val Orange = SubjectColor(Color(0xFFFFA34D), Color(0xFFFFF0DA), Color(0xFFB86A10))
    val Pink = SubjectColor(Color(0xFFF4779C), Color(0xFFFDE3EC), Color(0xFFC93A6A))
    val Purple = SubjectColor(Color(0xFF9B7AF5), Color(0xFFEDE6FD), Color(0xFF6B47CF))

    val all = listOf(Blue, Green, Orange, Pink, Purple)

    // Color usage order per subject (the Subject model has no color field yet).
    private val cycle = listOf(Blue, Green, Purple, Orange, Pink)

    fun forId(subjectId: Int): SubjectColor = cycle[(subjectId - 1).mod(cycle.size)]
}
