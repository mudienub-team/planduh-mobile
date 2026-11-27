package com.hehe.planduh.ui.components.atoms

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.StatusTone

/** Small unread dot (e.g. on the notification button). */
@Composable
fun PlanduhDot(modifier: Modifier = Modifier, color: Color = PlanduhColors.Error, size: Dp = 8.dp) {
    Box(modifier.size(size).clip(CircleShape).background(color))
}

/** Round tinted indicator with an icon (reminder). */
@Composable
fun PlanduhIndicator(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    tone: StatusTone = StatusTone.Warning,
    size: Dp = 32.dp,
    shape: Shape = CircleShape,
) {
    Box(modifier.size(size).clip(shape).background(tone.container), contentAlignment = Alignment.Center) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(size / 2), tint = tone.content)
    }
}

/** Round tinted indicator with a glyph ("!" for deadline). */
@Composable
fun PlanduhIndicator(
    glyph: String,
    modifier: Modifier = Modifier,
    tone: StatusTone = StatusTone.Warning,
    size: Dp = 32.dp,
    shape: Shape = CircleShape,
) {
    Box(modifier.size(size).clip(shape).background(tone.container), contentAlignment = Alignment.Center) {
        Text(glyph, style = MaterialTheme.typography.labelLarge.copy(fontWeight = FontWeight.Bold), color = tone.content)
    }
}
