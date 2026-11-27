package com.hehe.planduh.ui.components.molecules

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hehe.planduh.ui.theme.PlanduhColors
import com.hehe.planduh.ui.theme.PlanduhTextStyles
import com.komoui.components.Input

/** KomoUI Input with the uppercase label above it, as in the design ("MATA PELAJARAN"). */
@Composable
fun PlanduhField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    enabled: Boolean = true,
    isError: Boolean = false,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
) {
    Column(modifier) {
        Text(label.uppercase(), style = PlanduhTextStyles.fieldLabel, color = PlanduhColors.TextSecondary)
        Spacer(Modifier.height(6.dp))
        Input(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier.fillMaxWidth(),
            placeholder = placeholder,
            enabled = enabled,
            isError = isError,
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            singleLine = true,
        )
    }
}
