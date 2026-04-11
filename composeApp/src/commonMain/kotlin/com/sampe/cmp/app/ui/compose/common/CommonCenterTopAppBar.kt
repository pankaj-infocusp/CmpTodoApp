package com.sampe.cmp.app.ui.compose.common

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.sampe.cmp.app.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CommonCenterTopAppBar(
    modifier: Modifier = Modifier,
    title: String,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Text(
                style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
                text = title,
                color = MaterialTheme.colorScheme.tertiary,
            )
        },
        navigationIcon = navigationIcon,
        actions = actions
    )
}

@Preview
@Composable
private fun CenterTopBarPreview() {
    AppTheme {
        CommonCenterTopAppBar(
            title = "Todo App"
        )
    }
}
