package com.hehe.planduh.ui.components.molecules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.components.atoms.PlanduhIndicator
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.StatusTone

/** Task card: "!" indicator + title + deadline text. */
@Composable
fun TaskItem(
    title: String,
    deadlineText: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val shape = RoundedCornerShape(14.dp)
    Row(
        modifier
            .fillMaxWidth()
            .clip(shape)
            .background(PlanduhColors.Surface)
            .border(BorderStroke(1.dp, PlanduhColors.Border), shape)
            .clickable(onClick = onClick)
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        PlanduhIndicator(
            glyph = "!",
            tone = StatusTone.Warning,
            size = 40.dp,
            shape = RoundedCornerShape(12.dp),
        )
        Column(Modifier.weight(1f)) {
            Text(title, style = MaterialTheme.typography.titleSmall, color = PlanduhColors.TextPrimary)
            Text(deadlineText, style = MaterialTheme.typography.bodySmall, color = PlanduhColors.TextSecondary)
        }
    }
}
