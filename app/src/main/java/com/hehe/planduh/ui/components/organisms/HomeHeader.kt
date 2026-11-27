package com.hehe.planduh.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.components.atoms.PlanduhDot
import com.hehe.planduh.ui.theme.PlanduhColors
import com.komoui.components.ButtonVariant
import com.komoui.components.IconButton

/** Greeting + date on the left, notification button on the right. */
@Composable
fun HomeHeader(
    userName: String,
    dateText: String,
    hasUnreadNotification: Boolean,
    modifier: Modifier = Modifier,
    onNotificationClick: () -> Unit = {},
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Column {
            Text(
                "Halo, $userName",
                style = MaterialTheme.typography.headlineMedium,
                color = PlanduhColors.TextPrimary,
            )
            Text(dateText, style = MaterialTheme.typography.bodySmall, color = PlanduhColors.TextSecondary)
        }
        Box {
            IconButton(onClick = onNotificationClick, variant = ButtonVariant.Outline, shape = CircleShape) {
                Icon(Icons.Outlined.Notifications, contentDescription = "Notifikasi")
            }
            if (hasUnreadNotification) {
                PlanduhDot(
                    Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 6.dp, end = 6.dp),
                )
            }
        }
    }
}
