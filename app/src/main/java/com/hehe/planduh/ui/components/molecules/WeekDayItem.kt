package com.hehe.planduh.ui.components.molecules

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.theme.PlanduhColors

/** One day in the week strip: "Kam / 19". */
@Composable
fun WeekDayItem(
    dayLabel: String,
    dateNumber: Int,
    selected: Boolean,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Column(
        modifier
            .clip(RoundedCornerShape(12.dp))
            .background(if (selected) PlanduhColors.Primary else PlanduhColors.Surface)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
    ) {
        Text(
            dayLabel,
            style = MaterialTheme.typography.labelSmall,
            color = if (selected) PlanduhColors.TextInverse else PlanduhColors.TextSecondary,
        )
        Text(
            dateNumber.toString(),
            style = MaterialTheme.typography.titleSmall,
            color = if (selected) PlanduhColors.TextInverse else PlanduhColors.TextPrimary,
        )
    }
}
