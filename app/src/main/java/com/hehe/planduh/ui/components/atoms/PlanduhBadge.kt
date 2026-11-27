package com.hehe.planduh.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.PlanduhTextStyles
import com.hehe.planduh.ui.theme.StatusTone
import com.hehe.planduh.ui.theme.SubjectColor
import com.komoui.components.Badge

/** KomoUI Badge with soft status colors: "Selesai", "Berikutnya", "Aktif". */
@Composable
fun StatusBadge(text: String, modifier: Modifier = Modifier, tone: StatusTone = StatusTone.Primary) {
    Badge(modifier = modifier, backgroundColor = tone.container) {
        Text(text, color = tone.content)
    }
}

/** KomoUI Badge for a subject: "Matematika", "IPA". */
@Composable
fun SubjectBadge(text: String, subject: SubjectColor, modifier: Modifier = Modifier) {
    Badge(modifier = modifier, backgroundColor = subject.container) {
        Text(text, color = subject.content)
    }
}

/** Countdown / numeric badge in Roboto Mono: "25 menit lagi". */
@Composable
fun CountdownBadge(
    text: String,
    modifier: Modifier = Modifier,
    container: Color = PlanduhColors.Primary,
    content: Color = PlanduhColors.TextInverse,
) {
    Badge(modifier = modifier, backgroundColor = container) {
        Text(text, color = content, style = PlanduhTextStyles.monoSmall)
    }
}
