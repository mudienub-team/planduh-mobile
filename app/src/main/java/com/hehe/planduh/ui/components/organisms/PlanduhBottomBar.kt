package com.hehe.planduh.ui.components.organisms

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.navigation.PlanduhTab
import com.hehe.planduh.ui.theme.PlanduhColors

@Composable
fun PlanduhBottomBar(
    selected: PlanduhTab,
    onSelect: (PlanduhTab) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier
            .fillMaxWidth()
            .background(PlanduhColors.Surface)
            .navigationBarsPadding(),
    ) {
        Box(Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(PlanduhColors.Border))
        Row(Modifier.fillMaxWidth()) {
            PlanduhTab.entries.forEach { tab ->
                TabItem(
                    tab = tab,
                    selected = tab == selected,
                    onClick = { onSelect(tab) },
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}

@Composable
private fun TabItem(
    tab: PlanduhTab,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val tint = if (selected) PlanduhColors.Primary else PlanduhColors.TextSecondary
    Column(
        modifier
            .clickable(onClick = onClick)
            .padding(bottom = 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Box(
            Modifier
                .width(28.dp)
                .height(2.dp)
                .background(
                    color = if (selected) PlanduhColors.Primary else Color.Transparent,
                    shape = RoundedCornerShape(bottomStart = 2.dp, bottomEnd = 2.dp),
                ),
        )
        Icon(tab.icon, contentDescription = tab.label, modifier = Modifier.size(22.dp), tint = tint)
        Text(tab.label, style = MaterialTheme.typography.labelSmall, color = tint)
    }
}
