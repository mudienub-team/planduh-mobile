package com.hehe.planduh.ui.components.atoms

import androidx.compose.foundation.clickable
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.hehe.planduh.ui.theme.PlanduhColors

/** Small primary-colored action text: "Lihat mingguan", "Semua". */
@Composable
fun PlanduhTextLink(text: String, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Text(
        text = text,
        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.SemiBold),
        color = PlanduhColors.Primary,
        modifier = modifier.clickable(onClick = onClick),
    )
}
