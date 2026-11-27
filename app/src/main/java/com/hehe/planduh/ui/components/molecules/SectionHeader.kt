package com.hehe.planduh.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hehe.planduh.ui.components.atoms.PlanduhTextLink
import com.hehe.planduh.ui.theme.PlanduhColors

/** Section title + action on the right: "Jadwal Hari Ini" . "Lihat mingguan". */
@Composable
fun SectionHeader(
    title: String,
    modifier: Modifier = Modifier,
    actionLabel: String? = null,
    onActionClick: () -> Unit = {},
) {
    Row(
        modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(title, style = MaterialTheme.typography.titleMedium, color = PlanduhColors.TextPrimary)
        if (actionLabel != null) PlanduhTextLink(actionLabel, onActionClick)
    }
}
