package com.hehe.planduh.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.components.atoms.CountdownBadge
import com.hehe.planduh.ui.theme.PlanduhColors

/** Purple "PELAJARAN BERIKUTNYA" (next class) card on the Home screen. */
@Composable
fun NextClassCard(
    subjectName: String,
    timeRangeText: String,
    countdownText: String,
    modifier: Modifier = Modifier,
    onReminderClick: () -> Unit = {},
) {
    Column(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(PlanduhColors.Primary)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                "PELAJARAN BERIKUTNYA",
                style = MaterialTheme.typography.labelSmall,
                color = PlanduhColors.TextInverse.copy(alpha = 0.8f),
            )
            CountdownBadge(
                countdownText,
                container = PlanduhColors.Surface,
                content = PlanduhColors.Primary,
            )
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
        ) {
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Text(
                    subjectName,
                    style = MaterialTheme.typography.headlineSmall,
                    color = PlanduhColors.TextInverse,
                )
                Text(
                    timeRangeText,
                    style = MaterialTheme.typography.bodyMedium,
                    color = PlanduhColors.TextInverse.copy(alpha = 0.85f),
                )
            }
            Box(
                Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(Color.White.copy(alpha = 0.2f))
                    .clickable(onClick = onReminderClick),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "Pengingat",
                    modifier = Modifier.size(16.dp),
                    tint = PlanduhColors.TextInverse,
                )
            }
        }
    }
}
