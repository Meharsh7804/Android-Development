package com.example.lemonade.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val colorScheme = darkColorScheme(
    // customize your colors here if you want
)

@Composable
fun AppTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
