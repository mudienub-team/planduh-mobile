package com.hehe.planduh.ui.components.molecules

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.components.atoms.StatusBadge
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.PlanduhTextStyles
import com.hehe.planduh.ui.theme.StatusTone
import com.hehe.planduh.ui.theme.SubjectColor

enum class ScheduleStatus { Done, Next, Upcoming }

/** One schedule row: time column on the left, subject card on the right. */
@Composable
fun ScheduleItem(
    startTime: String,
    endTime: String?,
    title: String,
    room: String?,
    subjectColor: SubjectColor,
    status: ScheduleStatus,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    val done = status == ScheduleStatus.Done
    val shape = RoundedCornerShape(14.dp)

    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Column(Modifier.width(48.dp)) {
            Text(
                startTime,
                style = PlanduhTextStyles.monoMedium.copy(fontWeight = FontWeight.SemiBold),
                color = if (done) PlanduhColors.TextSecondary else PlanduhColors.TextPrimary,
            )
            if (endTime != null) {
                Text(endTime, style = PlanduhTextStyles.monoSmall, color = PlanduhColors.TextMuted)
            }
        }

        Row(
            Modifier
                .weight(1f)
                .height(IntrinsicSize.Min)
                .clip(shape)
                .background(PlanduhColors.Surface)
                .border(
                    border = if (status == ScheduleStatus.Next) {
                        BorderStroke(1.5.dp, PlanduhColors.Primary)
                    } else {
                        BorderStroke(1.dp, PlanduhColors.Border)
                    },
                    shape = shape,
                )
                .clickable(onClick = onClick)
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            Box(
                Modifier
                    .width(3.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(2.dp))
                    .background(subjectColor.solid),
            )
            Column(Modifier.weight(1f)) {
                Text(
                    title,
                    style = MaterialTheme.typography.titleSmall,
                    color = if (done) PlanduhColors.TextSecondary else PlanduhColors.TextPrimary,
                )
                if (room != null) {
                    Text(room, style = MaterialTheme.typography.bodySmall, color = PlanduhColors.TextSecondary)
                }
            }
            when (status) {
                ScheduleStatus.Done -> StatusBadge("Selesai", tone = StatusTone.Success)
                ScheduleStatus.Next -> StatusBadge("Berikutnya", tone = StatusTone.Primary)
                ScheduleStatus.Upcoming -> Icon(
                    Icons.Outlined.Notifications,
                    contentDescription = "Pengingat",
                    modifier = Modifier.size(20.dp),
                    tint = PlanduhColors.TextMuted,
                )
            }
        }
    }
}
