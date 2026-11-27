package com.hehe.planduh.ui.screens.notes

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.hehe.planduh.ui.theme.PlanduhColors

@Composable
fun NotesScreen(modifier: Modifier = Modifier) {
    Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = "this Catatan",
            style = MaterialTheme.typography.titleMedium,
            color = PlanduhColors.TextPrimary,
        )
    }
}
