package com.hehe.planduh.ui.components.atoms

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.theme.PlanduhColors

/** Filter chip ("Semua", "Belum selesai", "Mingguan", ...). KomoUI has no chip, so this is ours. */
@Composable
fun PlanduhChip(
    label: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Surface(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        shape = RoundedCornerShape(percent = 50),
        color = if (selected) PlanduhColors.Primary else PlanduhColors.Surface,
        contentColor = if (selected) PlanduhColors.TextInverse else PlanduhColors.TextSecondary,
        border = if (selected) null else BorderStroke(1.dp, PlanduhColors.Border),
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium.copy(
                fontWeight = if (selected) FontWeight.SemiBold else FontWeight.Medium,
            ),
            modifier = Modifier.padding(horizontal = 14.dp, vertical = 8.dp),
        )
    }
}
